package com.example.demo.javacoretest;

import java.util.concurrent.atomic.AtomicReference;

/**
 * �������������
 * ʹ���� CAS ԭ�Ӳ�����������ʱ��Ԥ��֮ǰ��״̬Ϊ null��֮�� owner ����Ϊ��ǰ�̣߳�
 * ����ʱ��Ԥ��֮ǰ��״̬Ϊ��ǰ�̣߳�֮�� owner ����Ϊ null��
 * ������һ���̼߳���������ڶ����߳�Ҳ���������ͻ�һֱ�� while ��ѭ����ֱ����һ���߳̽����󣬵ڶ����̲߳��ܿ�ʼ������ʼִ�С�������ֻ�ǽ���ǰ�̲߳�ͣ��ִ��ѭ���壬�������߳�״̬�ĸı䣬������Ӧ�ٶȸ��졣�����߳�����ͣ����ʱ�������½����ԣ���Ϊÿ���̶߳���Ҫִ�У�ռ��CPUʱ�䡣����߳̾��������ң����ұ�������ʱ��Ρ��ʺ�ʹ����������
 * 
 * @author whl
 *
 */
public class SpinLock {
	
	AtomicReference<Thread> owner = new AtomicReference<Thread>();
	private int count; //��һ��������������������ȡ�����ıȽ�
	
	public void lock() {
		
		Thread currentThread = Thread.currentThread();
		System.out.println(currentThread.getName()+"---get  lock");
		
		if(currentThread == owner.get()) {
			count ++;
			return;
		}
		
		while(!owner.compareAndSet(null, currentThread)) {
			//���߳�Խ��Խ�࣬ ����whileѭ�����˷�CPUʱ��Ƭ����CompareAndSet ��Ҫ��ζ�ͬһ�ڴ���з���
			
			//����ڴ�ľ�����Ȼ������X86�����ȡ�����ڴ����ߵķ�ʽ�������ڴ棬���Ի�����ڴ�����ٶ��½�(�����߳��Ϸ��ʻ���)�������Ӱ������ϵͳ������

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
