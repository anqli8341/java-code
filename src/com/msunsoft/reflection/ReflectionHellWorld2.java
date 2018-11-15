/**
 * 
 */
package com.msunsoft.reflection;

/**
 * @author anquan li
 *
 */
public class ReflectionHellWorld2 {

  /**
   * 
   */
  public ReflectionHellWorld2() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Class<?> c = null;
    try {
      c = Class.forName("com.msunsoft.reflection.Foo");
    } catch (Exception e) {
      e.printStackTrace();
    }
    Foo f = null;
    try {
      f = (Foo) c.newInstance();
      f.print();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
