package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.common.ResponseObserver;
import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.AllAccountsResponse;
import com.bishaladhikary.grpclearning.models.sec06.BalanceCheckRequest;
import com.bishaladhikary.grpclearning.models.sec06.WithdrawRequest;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class Lec02UnaryAsyncClientTest extends AbstractTest{


	private static final Logger log = LoggerFactory.getLogger(Lec02UnaryAsyncClientTest.class);

	@Test
	public void getBalanceAsyncTest() throws InterruptedException {

		//The following fail's in test for some reason to test properly
//		var latch = new CountDownLatch(1);
//
//		 this.asyncStub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(1).build(), new StreamObserver<AccountBalance>() {
//			@Override
//			public void onNext(AccountBalance accountBalance) {
//				log.info("AccountBalance fetched asynchronously : {}",accountBalance);
//				Assertions.assertEquals(99,accountBalance.getBalance());
//				latch.countDown();
//			}
//
//			@Override
//			public void onError(Throwable throwable) {
//
//			}
//
//			@Override
//			public void onCompleted() {
//
//			}
//		});
//
//		 latch.await();

		var request = BalanceCheckRequest.newBuilder()
				.setAccountNumber(1).build();
		var observer = ResponseObserver.<AccountBalance> create();
		this.asyncStub.getAccountBalance(request, observer);
		observer.await();
		Assertions.assertEquals(1,observer.getItems().size());
		Assertions.assertEquals(100,observer.getItems().getFirst().getBalance());
		Assertions.assertNull(observer.getThrowable());
	}

	@Test
	public void allAccountsTest()
	{
		var observer = ResponseObserver.<AllAccountsResponse> create();
		this.asyncStub.getAllAccounts(Empty.getDefaultInstance(),observer);
		observer.await();
		Assertions.assertEquals(1,observer.getItems().size());
		Assertions.assertEquals(10,observer.getItems().getFirst().getAccountsCount());
		Assertions.assertNull(observer.getThrowable());


	}


}
