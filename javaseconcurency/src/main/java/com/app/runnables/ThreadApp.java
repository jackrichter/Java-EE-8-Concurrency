package com.app.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadApp extends Thread {

	public void run() {
		
		try (BufferedReader reader = new BufferedReader(
				new FileReader(
						new File("sample.txt")))) {
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(Thread.currentThread().getName() + " reading the line: " + line);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(ThreadApp.class.getName()).log(Level.SEVERE, null, e);
		} catch (IOException e) {
			Logger.getLogger(ThreadApp.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
