package com.example.demo.javacoretest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ʹ�ò������е�ԭ��������࣬ͨ��cas �ķ�ʽ��֤��ԭ����
 * @author whl
 *
 */
public class Counter {
	
	AtomicInteger num = new AtomicInteger(0);

	public void changeCount() {
		for(int i=0;i<1000;i++) {
			num.incrementAndGet();
		}
	}
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		CountDownLatch countDownLatch = new CountDownLatch(30);
		
		for(int i=0;i<30;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					counter.changeCount();
					
					countDownLatch.countDown();
				}
				
				
			}).start();;
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(counter.num);
		
	}
}
