package com.test.thread;

public class ThreadDemo3 {

  public ThreadDemo3() {
    // TODO Auto-generated constructor stub
  }

  private static void demo3() {
    Object lock = new Object();
    Thread A = new Thread(() ->{
//      @Override
//      public void run() {
        // TODO Auto-generated method stub
        System.out.println("INFO: A 等待锁");
        synchronized (lock) {
          System.out.println("INFO: A 得到锁 lock");
          System.out.println("A1");
          try {
            System.out.println("INFO: A 准备进入等待状态，放弃锁");
            lock.wait();

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
//        }
        System.out.println("INFO: 有人唤醒了A，A重新获得锁 lock");
        System.out.println("A2");
        System.out.println("A3");

      }

    });
    Thread B = new Thread(()-> {

//      @Override
//      public void run() {
        // TODO Auto-generated method stub
        System.out.println("INFO: B 等待锁");
        synchronized (lock) {
          System.out.println("INFO: B 获得了锁 lock");
          System.out.println("B1");
          System.out.println("B2");
          System.out.println("B3");
          System.out.println("INFO: B 打印完毕，调用notify方法唤醒A");
          lock.notify();
        }
//      }

    });
    A.start();
    B.start();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    demo3();
  }

}
