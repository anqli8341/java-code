package com.test.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

  public CyclicBarrierDemo() {
    // TODO Auto-generated constructor stub
  }

  private static void runABCWhenAllReady() {
    int runner = 3;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
    final Random random = new Random();
    for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
      final String rN = String.valueOf(runnerName);
      new Thread(()-> {

//        @Override
//        public void run() {
          // TODO Auto-generated method stub
          long prepareTime = random.nextInt(10000) + 100;
          System.out.println(rN + " is preparing for time:" + prepareTime);
          try {
            Thread.sleep(prepareTime);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          try {
            System.out.println(rN + " is prepared waiting for others");
            cyclicBarrier.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (BrokenBarrierException e) {
            e.printStackTrace();
          }
          System.out.println(rN + " starts running ");
//        }

      }).start();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    runABCWhenAllReady();
  }

}
