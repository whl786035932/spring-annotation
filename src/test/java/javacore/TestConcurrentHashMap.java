package javacore;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class TestConcurrentHashMap {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> count = new ConcurrentHashMap<>();
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				Integer oldValue , newValue;
				for(int i =0; i<5;i++) {
					while(true) {
						oldValue = count.get("a");
						if(null == oldValue) {
							newValue = 1;
							
							if(count.putIfAbsent("a", newValue) == null) {
								System.out.println("#########="+count);
								break;
							}
						}else {
							newValue = oldValue+1;
							if(count.replace("a", oldValue, newValue)) {
								System.out.println("===="+count);
								break;
							}
						}
					}
				}
				
			}
		};
		
		new Thread(runnable).start();
		new Thread(runnable).start();
		System.out.println(count);
	}
	
	@Test
	public void testAotmic() {
		ConcurrentHashMap<String, AtomicInteger> count = new ConcurrentHashMap<>();
		
		Runnable runnable = new Runnable() {
		
			@Override
			public void run() {
				
				AtomicInteger oldValue ;
				
				for(int i=0;i<5;i++) {
					oldValue = count.get("a");
					if(null == oldValue) {
						AtomicInteger zeroValue = new AtomicInteger(0);
						oldValue = count.putIfAbsent("a", zeroValue);
						if(null == oldValue) {
							oldValue = zeroValue;
						}
					}
					oldValue.incrementAndGet();
					System.out.println(count);
				}
			}
		};
		
		new Thread(runnable).start();
		new Thread(runnable).start();
	}
}
