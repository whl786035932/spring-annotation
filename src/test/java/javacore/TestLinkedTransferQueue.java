package javacore;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public   class TestLinkedTransferQueue extends ThreadPoolExecutor implements RejectedExecutionHandler  {
	public TestLinkedTransferQueue(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public static void main(String[] args) {
		LinkedTransferQueue<Object> linkedTransferQueue = new LinkedTransferQueue<>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, null);
		Future<?> submit = threadPoolExecutor.submit(new Runnable() {
			
			@Override
			public void run() {
				
			}
		});
		threadPoolExecutor.getPoolSize();
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		threadPoolExecutor.getQueue();
		
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
	}	
	
	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		
		
	};
	
	
}
