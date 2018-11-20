package com.test.thread;

public class ThreadJoinDemo {

  public ThreadJoinDemo() {
    // TODO Auto-generated constructor stub
  }

  public static void demo1() {
    Thread A = new Thread(()-> {
//      public void run() {
        printNumber("A");
//      }
    });
    Thread B = new Thread(()-> {
//      public void run() {
        System.out.println("B 开始等待  A");
        try {
          A.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        printNumber("B");
//      }
    });
    A.start();
    B.start();
  }

  protected static void printNumber(String threadName) {
    // TODO Auto-generated method stub
    int i = 0;
    while (i++ < 3) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(threadName + " print: " + i);
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    demo1();
  }

}
