package com.bishal.grpclearning.sec06;

import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.AllAccountsResponse;
import com.bishaladhikary.grpclearning.models.sec06.BalanceCheckRequest;
import com.bishaladhikary.grpclearning.models.sec06.BankServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GrpcClient {


	private static final Logger log = LoggerFactory.getLogger(GrpcClient.class);

	public static void main(String... args) throws InterruptedException {
		var channel  = ManagedChannelBuilder.forAddress("localhost",6565)
				.usePlaintext()
				.build();

//		var stub = BankServiceGrpc.newBlockingStub(channel);
		var stub = BankServiceGrpc.newStub(channel);

//		var balance = stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(1).build());

		stub.getAccountBalance(BalanceCheckRequest.newBuilder().setAccountNumber(1).build(), new StreamObserver<AccountBalance>() {
			@Override
			public void onNext(AccountBalance accountBalance) {
				log.info("{}", accountBalance);
			}

			@Override
			public void onError(Throwable throwable) {

			}

			@Override
			public void onCompleted() {
				log.info("Completed");
			}
		});
//		log.info("{}",balance);


		stub.getAllAccounts(Empty.getDefaultInstance(),new StreamObserver<AllAccountsResponse>() {


			@Override
			public void onNext(AllAccountsResponse allAccountsResponse) {
				List<AccountBalance> accounts = allAccountsResponse.getAccountsList();
				accounts.forEach((e)-> log.info("/n {}",e));
			}

			@Override
			public void onError(Throwable throwable) {

			}

			@Override
			public void onCompleted() {

			}
		});



		Thread.sleep(5000);
	}


}
