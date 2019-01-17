package com.example.demo.javacoretest;

import java.util.concurrent.atomic.AtomicReference;

public class BadSpinLock {

	AtomicReference<Thread> owner = new AtomicReference<Thread>();
	
	public void lock() {
		Thread cur = Thread.currentThread();
		while(!owner.compareAndSet(null, cur)) {
			System.out.println(cur.getName() +" wait lock release");
		}
	}
	
	public void unlock() {
		
		Thread cur = Thread.currentThread();
		if(cur == owner.get()) {
			 owner.compareAndSet(cur, null);
			 System.out.println(cur.getName()+"  release lock");
		}
		
	}
}
