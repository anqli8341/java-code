package com.test.thread;

import java.util.concurrent.CountDownLatch;

public class ThreadCountDownLatch {

  public ThreadCountDownLatch() {
    // TODO Auto-generated constructor stub
  }

  private static void runDAfterABC() {
    int worker = 3;
    CountDownLatch countDownLatch = new CountDownLatch(worker);
    new Thread(new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        System.out.println("D is waiting for other thress thread");
        try {
          countDownLatch.await();
          System.out.println("All done,D starts working");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }).start();
    for (char threadName = 'A'; threadName <= 'C'; threadName++) {
      final String tN = String.valueOf(threadName);
      new Thread(new Runnable() {

        @Override
        public void run() {
          // TODO Auto-generated method stub
          System.out.println(tN + " is working");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(tN + " finished");
          countDownLatch.countDown();
        }

      }).start();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    runDAfterABC();

  }

}
