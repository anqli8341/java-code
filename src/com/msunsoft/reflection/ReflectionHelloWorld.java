/**
 * 
 */
package com.msunsoft.reflection;

import java.lang.reflect.Method;

/**
 * @author anquan li
 *
 */
public class ReflectionHelloWorld {

  /**
   * 
   */
  public ReflectionHelloWorld() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Foo f = new Foo();
    Method method;
    try {
      method = f.getClass().getMethod("print", new Class<?>[0]);
      method.invoke(f);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }

}
