package com.example.demo.javacoretest;

public class TestSpinLock implements Runnable {
	
	static int sum;
	private SpinLock lock;
	
	 public TestSpinLock(SpinLock lock) {
		 this.lock = lock;
	 }
	 
	 
	public static void main(String[] args) throws InterruptedException {
		
		SpinLock spinLock = new SpinLock();
		for(int i=0;i<100;i++) {
			TestSpinLock test = new TestSpinLock(spinLock);
			Thread thread = new Thread(test);
			thread.start();
		}
		
		Thread.currentThread().sleep(1000);
		System.out.println(sum);
		
		
	}
	@Override
	public void run() {
		this.lock.lock();
		this.lock.lock();
		sum++;
		this.lock.unlock();
		this.lock.unlock();
		
	}

}
