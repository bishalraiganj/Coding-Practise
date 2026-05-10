package com.bishal.grpclearning.sec06;

import com.bishaladhikary.grpclearning.models.sec06.AccountBalance;
import com.bishaladhikary.grpclearning.models.sec06.AllAccountsResponse;
import com.bishaladhikary.grpclearning.models.sec06.BalanceCheckRequest;
import com.google.protobuf.Empty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lec01UnaryBlockingClientTest extends AbstractTest{

	private static final Logger log = LoggerFactory.getLogger(Lec01UnaryBlockingClientTest.class);

	@Test
	public void getBalanceTest()
	{
		var request = BalanceCheckRequest.newBuilder().setAccountNumber(1).build();
		var balance = this.stub.getAccountBalance(request);
		log.info("Unary balance received: {}",balance);
		Assertions.assertEquals(100,balance.getBalance());
	}


	@Test
	public void allAccountsTest()
	{
//		var testExpectedData = IntStream.range(1,10)
//				.boxed()
//				.collect(Collectors.toConcurrentMap(Function.identity(),v -> 100));


		var testExpectedData  = IntStream.rangeClosed(1,10)
				.boxed()
				.map((i)-> AccountBalance.newBuilder().setAccountNumber(i).setBalance(100).build())
				.toList();

		AllAccountsResponse fetchedData = stub.getAllAccounts(Empty.newBuilder().build());
		 var fetchedList = fetchedData.getAccountsList();

		 for(AccountBalance balance : fetchedList)
		 {
			 log.info("AccountBalance fetched: {}",balance);
		 }

		 for(AccountBalance balance : testExpectedData)
		 {
			 log.info("AccountBalance received: {}",balance);
		 }


		Assertions.assertEquals(testExpectedData.size(),fetchedList.size());
		Assertions.assertEquals(testExpectedData,fetchedList);



	}

}
