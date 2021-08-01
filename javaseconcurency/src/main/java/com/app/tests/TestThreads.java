package com.app.tests;

import com.app.runnables.ThreadApp;

public class TestThreads {

	public static void main(String[] args) {
		ThreadApp thread1 = new ThreadApp();	// NEW
		ThreadApp thread2 = new ThreadApp();
		ThreadApp thread3 = new ThreadApp();
		
		thread1.start();		// RUNNABLE
		thread2.start();
		thread3.start();
		// Executing - RUNNING
		// Job completed - TERMINATED/DEAD
	}
}
