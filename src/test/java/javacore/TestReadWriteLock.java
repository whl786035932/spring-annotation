package javacore;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

import org.springframework.beans.factory.annotation.Autowired;

public class TestReadWriteLock {

	@Autowired
public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition newCondition = reentrantLock.newCondition();
		ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		

		new Thread(() ->{
			readWriteLock.readLock().lock();
			
			System.out.println(new Date()+"\t Thread 2 started with read lock");
			try {
				
				Thread.sleep(2000);
				System.out.println(new Date()+"\t Thread 2 end ");
			}catch(Exception e) {
				
			}finally {
				readWriteLock.readLock().unlock();
			}
		})  .start();
		
		
		
		new Thread(() -> {
			ReadLock readLock = readWriteLock.readLock();
			readLock.lock();
			try {
				System.out.println(new Date()+"\t Thread 1 started with read lock");
				Thread.sleep(2000);
				System.out.println(new Date()+"\t Thread 1 end");
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				ReadLock readLock2 = readWriteLock.readLock();
				readLock2.unlock();
			}
		} ).start();
		new Thread(()->{
			
			readWriteLock.writeLock().lock();
			System.out.println(new Date()+"\t Thread 3 started with write lock");
			try {
				Thread.sleep(1000);
				System.out.println(new Date()+"\t Thread 3 end");
			}catch(Exception e) {
				
			}finally {
				readWriteLock.writeLock().unlock();
			}
		}) .start();
		
		
		new Thread(()->{
			
			readWriteLock.writeLock().lock();
			System.out.println(new Date()+"\t Thread 4 started with write lock");
			try {
				Thread.sleep(500);
				System.out.println(new Date()+"\t Thread 4 end");
			}catch(Exception e) {
				
			}finally {
				readWriteLock.writeLock().unlock();
			}
		}) .start();
	}
}
