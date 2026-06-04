package com.bishal.grpclearning.sec06.requestHandlers;

import com.bishal.grpclearning.sec06.repository.AccountRepository;
import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.DepositRequest;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DepositRequestHandler implements StreamObserver<DepositRequest>  {


	private static final Logger  log = LoggerFactory.getLogger(DepositRequestHandler.class);
	private final StreamObserver<AccountBalance> responseObserver;
	private int accountNumber;

	public DepositRequestHandler(StreamObserver<AccountBalance> responseObserver) {
		this.responseObserver = responseObserver;
	}


	@Override
	public void onNext(DepositRequest value) {

		switch ( value.getRequestCase()){
			case ACCOUNT_NUMBER -> this.accountNumber = value.getAccountNumber();
			case MONEY -> AccountRepository.addAmount(this.accountNumber,value.getMoney().getAmount());
		}
	}

	@Override
	public void onError(Throwable t) {

		log.info( "Client  Error message: {} ", t.getMessage());

		this.responseObserver.onError(t);

	}

	@Override
	public void onCompleted() {

		var accountBalance = com.bishaladhikary.grpclearning.models.sec06.AccountBalance.newBuilder()
				.setAccountNumber(this.accountNumber)
				.setBalance(AccountRepository.getBalance(this.accountNumber))
				.build();

		responseObserver.onNext(accountBalance);
		responseObserver.onCompleted();

	}
}
