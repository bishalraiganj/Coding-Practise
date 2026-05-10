package com.bishal.grpclearning.sec06;

import com.bishal.grpclearning.common.AbstractChannelTest;
import com.bishal.grpclearning.common.GrpcServer;
import com.bishaladhikary.grpclearning.models.sec06.BankServiceGrpc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractTest  extends AbstractChannelTest {

		private final GrpcServer server = GrpcServer.create(new BankService());
		protected BankServiceGrpc.BankServiceBlockingStub stub;
		protected BankServiceGrpc.BankServiceStub asyncStub;

		@BeforeAll
		public void setup()
		{
			this.server.start();
			this.asyncStub = BankServiceGrpc.newStub(channel);
			this.stub=BankServiceGrpc.newBlockingStub(channel);
		}


		@AfterAll
		public void stop()
		{
			this.server.stop();
		}

}
