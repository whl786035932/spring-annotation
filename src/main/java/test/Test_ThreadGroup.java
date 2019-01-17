package test;

import org.junit.Test;

public class Test_ThreadGroup {
	
	@Test
	public void testThreadGroup() {
		Runnable runnable= ()->{
			 System.out.println("Java����ջ�߳��߳������ƣ�" + Thread.currentThread().getThreadGroup());
		        System.out.println("Java����ջ�߳��߳����ƣ�" + Thread.currentThread().getName());
		        try {
		            Thread.sleep(3000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		};
		
		ThreadGroup userGroup = new ThreadGroup("user");
		userGroup.setMaxPriority(Thread.MAX_PRIORITY);
		
		Thread userTask1 = new Thread(userGroup,runnable,"user-task1");
		Thread userTask2 = new Thread(userGroup,runnable,"user-task2");
		
		userTask1.start();
		userTask2.start();
		System.out.println("Java����ջ�߳��߳����Ծ�߳�����" + userGroup.activeCount());
		userGroup.list();
		
		
	}

}
