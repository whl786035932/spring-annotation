package com.example.demo.javacoretest;

public class VolatileTest {
	
	private int a = 1;
	private int b =2; 
	
	public void change() {
		a = 3;
		b = a;
	}
	
	public void print() {
		System.out.println("b="+b+";a="+a);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10000;i++) {
			
			VolatileTest test = new VolatileTest();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.change();
					
				}
			}).start();
			
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					test.print();
				}
			}).start();
		}
			
		
	}

}
