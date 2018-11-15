package com.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

  public FutureTaskDemo() {
    // TODO Auto-generated constructor stub
  }

  private static void doTaskWithResultInWorker() {
    Callable<Integer> callable = new Callable<Integer>() {

      @Override
      public Integer call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println(" Task starts ");
        Thread.sleep(1000);
        int result = 0;
        for (int i = 0; i <= 100; i++) {
          result += i;
        }
        System.out.println("Task finished and return result");
        return result;
      }

    };
    FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
    new Thread(futureTask).start();
    try {
      System.out.println("Before futureTask.get()");
      System.out.println("Result:" + futureTask.get());
      System.out.println("After futureTask.get()");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    doTaskWithResultInWorker();
  }

}
