package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.sec06.repository.AccountRepository;
import com.bishal.grpclearning.sec06.requestHandlers.DepositRequestHandler;
import com.bishaladhikary.grpclearning.models.sec06.*;
import com.bishaladhikary.grpclearning.models.sec06.BankServiceGrpc;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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


	@Override
	public void withdraw(WithdrawRequest request, StreamObserver<Money> responseObserver) {
		var accountNumber = request.getAccountNumber();
		var requestAmount = request.getAmount();
		var availableBalance =  AccountRepository.getBalance(accountNumber);

		if(requestAmount > availableBalance) {
			responseObserver.onCompleted();
		return;
		}

		for( int i = 0 ; i < requestAmount / 10 ; i++)
		{
			var money = Money.newBuilder().setAmount(10).build();
			responseObserver.onNext(money);
			log.info("money sent {}", money);
			AccountRepository.deduceAmount(accountNumber, 10);
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

		}
;
		responseObserver.onCompleted();

	}

	@Override
	public StreamObserver<DepositRequest> deposit(StreamObserver<AccountBalance> responseObserver) {
		return new DepositRequestHandler(responseObserver);
	}
}