package SyncAsync;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SyncAsyncExample {



	public static void main(String... args)
	{

		int testCount = 0 ;

		long startTime = System.currentTimeMillis();

		//Sync + blocking example
		//The invocation of helper() is synchronous because main thread waits for it to complete and
		//does not do something else because the control does not return immediately to execute the following
		//instructions or codes
		// since , the caller stops (idle/blocked) it is blocking as well
//		helper(" Test No.%d \n ".formatted(++testCount));
//		System.out.println("write Completed in %d seconds @%s now in main thread".formatted((System.currentTimeMillis()-startTime)/1000,LocalDateTime.now().toLocalTime()));


		//Async + Non-blocking example 1
		ExecutorService executor = Executors.newFixedThreadPool(10);
//		Future f = executor.submit(()->{
//			helper(" Test No.%d \n ".formatted(2));
//		});
//
//		while(!f.isDone())
//		{
//			System.out.println("-".repeat(50));
//			try {
//				Thread.sleep(1000);
//			}catch(InterruptedException e)
//			{
//				throw new RuntimeException(e);
//			}
//			System.out.println("! INCOMPLETE ! main thread,  @%s ".formatted(LocalDateTime.now().toLocalTime() + "\n"));
//			System.out.println("-".repeat(50));
//		}
//
//		System.out.println(" ! COMPLETED ! , in Main Thread @%s".formatted(LocalDateTime.now().toLocalTime() +"\n"));



		//Asynchronous + blocking (only if system wide , some thread is blocked/idle doing i/o task ,non-blocking if task finishes immediately)
		//Asynchronous + non-blocking (the following because , thenAccept() finishes immediately
		//The caller is not waiting (since , control returns immediatley and caller is free to execute /do other tasks following instructions )
		//but the worker thread will block for the i/o task , as in helper()  we have bw.write(str)
		// the worker thread is one of fixedThreadPool's thread

		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(()->{

			return helper(" Test No.%d \n ".formatted(3));

		},executor).thenAccept((val)->{
			System.out.println(" helper() completed: in Thread:(%s),  @%s ".formatted(Thread.currentThread().getName(),LocalDateTime.now().toLocalTime() + "\n"));


		});

		System.out.println("In MAIN Thread : @%s ".formatted(LocalDateTime.now().toLocalTime() + "\n"));
		executor.shutdown();


	}



	//It is a Synchronous Blocking method , currently designed to block for 2 seconds (worker thread sleeps for 2 seconds)
	public static LocalDateTime helper(String str)
	{


		Path p = Path.of("./Java/SyncAsync/dataFile.txt");

		try {
			if (!Files.exists(p)) //Checks if the file exists , regardless of the type of the file
			{
				Files.createFile(p);
				System.out.println("File Created  at " + p.toString());

			}

			try(BufferedWriter bw = new BufferedWriter(new FileWriter("./Java/SyncAsync/dataFile.txt",true)))
			{
				bw.write(str);
				System.out.println("Written:(%s) by Thread:(%s) , Sleeping for(2s) @ %s".formatted(str,Thread.currentThread().getName(),LocalDateTime.now().toLocalTime()));

				Thread.sleep(2000);
				System.out.println("Thread Sleep complete :(%s) @%s".formatted(Thread.currentThread().getName(),LocalDateTime.now().toLocalTime()));
			}
		}catch(IOException | InterruptedException e)
		{
			throw new RuntimeException(e);
		}


		return LocalDateTime.now();

	}








}
