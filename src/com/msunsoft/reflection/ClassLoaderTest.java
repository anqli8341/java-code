package com.msunsoft.reflection;

public class ClassLoaderTest {

  public ClassLoaderTest() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    System.out.println("classLoader is " + classLoader.getClass());
    System.out.println("classLoader Parent is " + classLoader.getParent());
    System.out.println("classLoader gardenFather is " + classLoader.getParent().getParent());

  }

}
