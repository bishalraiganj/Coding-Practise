package com.bishal.grpclearning.common;

import com.bishal.grpclearning.sec06.BankService;

public class Demo {

	public static void main(String[] args) {

		GrpcServer.create(new BankService())
				.start()
				.await();

	}
}