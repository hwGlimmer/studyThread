package com.glimmer.thread2;

/**
 * 实现线程方法1：实现Runnable接口
 * 
 * 1】定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
 *
 * 2】创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
 *
 * 3】第三部依然是通过调用线程对象的start()方法来启动线程
 * @author Glimmer
 *
 */

public class Test2 {
    public static void main(String[] args)  {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }
} 

class MyThread2 implements Runnable{

	public MyThread2() {
		
	}

	@Override
	public void run() {

		System.out.println("子线程ID："+Thread.currentThread().getId());

	}
	
}



