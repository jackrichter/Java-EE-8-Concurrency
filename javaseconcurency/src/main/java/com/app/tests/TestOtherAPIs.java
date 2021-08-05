package com.app.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.app.runnables.LoggingProcessor;

public class TestOtherAPIs {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables = new ArrayList<Callable<Boolean>>();
		
		try {	
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			callables.add(new LoggingProcessor());
			
			List<Future<Boolean>> futures = service.invokeAll(callables);
			
			for(Future<Boolean> future : futures) {
				System.out.println("operation result: " + future.get());
			}
		} catch (InterruptedException e) {
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		} catch (ExecutionException e) {
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		}
		
		// invokeAny
		try {
			System.out.println("\nResult of the first future to return: " + service.invokeAny(callables));
		} catch (InterruptedException e) {
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		} catch (ExecutionException e) {
			Logger.getLogger(TestOtherAPIs.class.getName()).log(Level.SEVERE, null, e);
		}
		
		System.out.println("Main terminated!");
		service.shutdown();
		
		try {
			System.out.println("service shut down? " + service.awaitTermination(30, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			service.shutdownNow();
			e.printStackTrace();
		}
	}
}
