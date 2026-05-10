package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.sec06.repository.AccountRepository;
import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.AllAccountsResponse;
import com.bishaladhikary.grpclearning.models.sec06.BalanceCheckRequest;
import com.bishaladhikary.grpclearning.models.sec06.BankServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

	private static final Logger log = LoggerFactory.getLogger(BankService.class);

	@Override
	public void getAccountBalance(BalanceCheckRequest request, StreamObserver<AccountBalance> responseObserver) {
		log.info("request received {}", request.getAccountNumber());
		var accountNumber = request.getAccountNumber();
		var balance = AccountRepository.getBalance(accountNumber);
		var accountBalance = AccountBalance.newBuilder()
				.setAccountNumber(accountNumber)
				.setBalance(balance)
				.build();
		responseObserver.onNext(accountBalance);
		responseObserver.onCompleted();
	}


	@Override
	public void getAllAccounts(Empty request, StreamObserver<AllAccountsResponse> responseObserver) {

		var accounts    = AccountRepository.getAllAccounts()
				.entrySet()
				.stream()
				.map((e)->AccountBalance.newBuilder().setAccountNumber(e.getKey()).setBalance(e.getValue()).build())
				.collect(

						()->new ArrayList<>(),
						(ArrayList<AccountBalance> list,AccountBalance ab)-> list.add(ab),
						(l1,l2)-> l1.addAll(l2));

		var response = AllAccountsResponse.newBuilder().addAllAccounts(accounts).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();

	}
}