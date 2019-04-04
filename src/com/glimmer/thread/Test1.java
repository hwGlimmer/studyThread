package com.glimmer.thread;

/**
 * 实现线程方法1： 继承Thread类
 * 
 * 1】d定义Thread类的子类，并重写该类的run()方法，该方法的方法体就是线程需要完成的任务，run()方法也称为线程执行体。
 * 
 * 2】创建Thread子类的实例，也就是创建了线程对象
 *
 * 3】启动线程，即调用线程的start()方法
 * 
 * 1）thread1和thread2的线程ID不同，thread2和主线程ID相同，说明通过run方法调用并不会创建新的线程，而是在主线程中直接运行run方法，跟普通的方法调用没有任何区别；
 *
 * 2）虽然thread1的start方法调用在thread2的run方法前面调用，但是先输出的是thread2的run方法调用的相关信息，说明新线程创建的过程不会阻塞主线程的后续执行。
 * @author Glimmer
 *
 */
public class Test1 {
    public static void main(String[] args)  {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        MyThread thread1 = new MyThread("thread1");
        thread1.start();
        MyThread thread2 = new MyThread("thread2");
        thread2.run();
    }
}
 
class MyThread extends Thread{
    private String name;
 
    public MyThread(String name){
        this.name = name;
    }
 
    @Override
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}
