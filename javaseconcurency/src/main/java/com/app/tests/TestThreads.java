package com.app.tests;

import com.app.runnables.ThreadApp;

public class TestThreads {

	public static void main(String[] args) {
		ThreadApp thread1 = new ThreadApp();
		ThreadApp thread2 = new ThreadApp();
		ThreadApp thread3 = new ThreadApp();
		
		thread1.start();
		thread2.start();
		thread3.start();

	}
}
