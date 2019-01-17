package com.example.demo.javacoretest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 可重入的自旋锁
 * 使用了 CAS 原子操作，当加锁时，预测之前的状态为 null，之后将 owner 设置为当前线程；
 * 解锁时，预测之前的状态为当前线程，之后将 owner 设置为 null。
 * 这样第一个线程加锁后，如果第二个线程也来加锁，就会一直在 while 中循环，直到第一个线程解锁后，第二个线程才能开始真正开始执行。自旋锁只是将当前线程不停地执行循环体，不进行线程状态的改变，所以响应速度更快。但当线程数不停增加时，性能下降明显，因为每个线程都需要执行，占用CPU时间。如果线程竞争不激烈，并且保持锁的时间段。适合使用自旋锁。
 * 
 * @author whl
 *
 */
public class SpinLock {
	
	AtomicReference<Thread> owner = new AtomicReference<Thread>();
	private int count; //用一个计数器来做重入锁获取次数的比较
	
	public void lock() {
		
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName()+"---get  lock");
		
		if(currentThread == owner.get()) {
			count ++;
			return;
		}
		
		while(!owner.compareAndSet(null, currentThread)) {
			//当线程越来越多， 由于while循环会浪费CPU时间片，，CompareAndSet 需要多次对同一内存进行访问
			
			//造成内存的竞争，然而对于X86，会采取竞争内存总线的方式来访问内存，所以会造成内存访问速度下降(其他线程老访问缓存)，因而会影响整个系统的性能

		}
		
		
	}
	
	public void unlock() {
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName()+"---release");
		if(currentThread==owner.get()) {
			if(count >0) {
				count --;
			}else {
				owner.compareAndSet(currentThread, null);
			}
		}
	}
}
