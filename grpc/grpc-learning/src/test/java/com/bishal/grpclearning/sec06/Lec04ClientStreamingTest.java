package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.common.ResponseObserver;
import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.DepositRequest;
import com.bishaladhikary.grpclearning.models.sec06.Money;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Lec04ClientStreamingTest extends AbstractTest {

	@Test
	public void depositTest()
	{
		var responseObserver = ResponseObserver. <AccountBalance> create();
		var requestObserver  = this.asyncStub.deposit(responseObserver);

		requestObserver.onNext(DepositRequest.newBuilder().setAccountNumber(5).build());
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		requestObserver.onError(new RuntimeException("Runtime time exception intentionally sent to cancel manually"));



//		IntStream.rangeClosed(1,10)
//				.mapToObj( i -> Money.newBuilder().setAmount(10).build())
//				.map(m -> DepositRequest.newBuilder().setMoney(m).build())
//				.forEach(requestObserver::onNext);
//
//		requestObserver.onCompleted();
//
		responseObserver.await();
//
//		Assertions.assertEquals(1,responseObserver.getItems().size());
//		Assertions.assertEquals(200,responseObserver.getItems().getFirst().getBalance());
//		Assertions.assertNull(responseObserver.getThrowable());

	}

}
