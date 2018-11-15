/**
 * 
 */
package com.test.thread;

/**
 * @author anquan li
 *
 */
public class ThreadDemo1 {

  /**
   * 
   */
  public ThreadDemo1() {
    // TODO Auto-generated constructor stub
  }

  public static void demo1() {
    Thread A = new Thread(new Runnable() {
      public void run() {
        printNumber("A");
      }
    });
    Thread B = new Thread(new Runnable() {
      public void run() {
        printNumber("B");
      }
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

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    demo1();
  }

}
