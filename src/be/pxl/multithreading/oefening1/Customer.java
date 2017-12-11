package be.pxl.multithreading.oefening1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Customer {
	private String name;
	private LocalDateTime timeInLine;
	private LocalDateTime timeOutOfLine;
	private int transactionTime;
	private long totalWaitTime;
	
	public Customer (String name){
		Random rand = new Random();
		this.name = name;
		this.transactionTime = rand.nextInt(9001) + 1000;
	}

	public int getTransactionTime() {
		return transactionTime;
	}
	
	public void inLine(){
		timeInLine = LocalDateTime.now();
	}
	
	public long outOfLine(){
		this.timeOutOfLine = LocalDateTime.now();
		this.totalWaitTime = ChronoUnit.SECONDS.between(timeInLine, timeOutOfLine);
		return totalWaitTime;
	}

	public String getName() {
		return name;
	}
}
