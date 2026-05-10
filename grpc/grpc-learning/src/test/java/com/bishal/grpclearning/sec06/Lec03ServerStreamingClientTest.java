package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.common.ResponseObserver;
import com.bishaladhikary.grpclearning.models.sec06.Money;
import com.bishaladhikary.grpclearning.models.sec06.WithdrawRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec03ServerStreamingClientTest extends AbstractTest{


	private static final Logger log = LoggerFactory.getLogger(Lec03ServerStreamingClientTest.class);

	@Test
	public void blockingClientWithdrawTest()
	{
		var request = WithdrawRequest.newBuilder().
				setAccountNumber(1)
				.setAmount(30).build();
		var iterator = stub.withdraw(request);
		var count = 0;

		while(iterator.hasNext())
		{
			log.info("received money: {}", iterator.next());
			count++;
		}

		Assertions.assertEquals(3,count);
	}


	@Test
	public void asyncClientWithdrawTest()
	{
			var request = WithdrawRequest.newBuilder().
				setAccountNumber(1)
				.setAmount(30).build();

		var observer = ResponseObserver.<Money> create();
				this.asyncStub.withdraw(request,observer );
				observer.await();
				Assertions.assertEquals(3,observer.getItems().size());
				Assertions.assertEquals(10,observer.getItems().getFirst().getAmount());
				Assertions.assertNull(observer.getThrowable());

	}


}
