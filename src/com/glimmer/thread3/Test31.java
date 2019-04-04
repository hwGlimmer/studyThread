package com.glimmer.thread3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 实现线程方法3-1：实现Callable接口
 * 
 * 1】创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。
 * 
 * 2】使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
 
 * 3】使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
 * 
 * 4】调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
 * @author Glimmer
 *
 */
public class Test31 {

	public static void main(String[] args) throws Exception, ExecutionException  {
			
		System.out.println("主线程ID："+Thread.currentThread().getId());
		
		  // 1.通过ExecutorService和Feature返回线程结果
//	      ExecutorService executor = Executors.newCachedThreadPool();
//	      Callable<String> callable = new Mythread31();
//		  Future<String> result = executor.submit(callable);
//		  executor.shutdown();
		
//		  // 2.利用FutureTask得到返回值，FutureTask被提交给Executor执行以得到返回值
//	      ExecutorService executor = Executors.newCachedThreadPool();
//		  Callable<String> callable = new Mythread31();
//	      FutureTask<String> result = new FutureTask<String>(callable);
//		  executor.submit(result);
//		  executor.shutdown();
		
		  // 启动方式3：FutureTask将作为Runnable被线程执行
		  Callable<String> callable = new Mythread31();
		  //由Callable<Integer>创建一个FutureTask<Integer>对象： 
		  FutureTask<String> result = new FutureTask<String>(callable);
		  //注释：FutureTask<Integer>是一个包装器，它通过接受Callable<Integer>来创建， 它同时实现了Future和Runnable接口。 //由FutureTask<Integer>创建一个Thread对象： 
		  Thread thread = new Thread(result); 
		  thread.start();
		 
		 System.out.println("线程返回值："+ result.get());
	}
}

class Mythread31 implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("线程打印信息："+Thread.currentThread().getId());
		return "此线程返回子线程ID："+Thread.currentThread().getId();
	}
	
}