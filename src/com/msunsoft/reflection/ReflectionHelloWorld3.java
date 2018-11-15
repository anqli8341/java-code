/**
 * 
 */
package com.msunsoft.reflection;

import java.lang.reflect.Constructor;

/**
 * @author anquan li 
 * 
 * 通过构造方法产生对象
 *
 */
public class ReflectionHelloWorld3 {

  /**
   * 
   */
  public ReflectionHelloWorld3() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Class<?> c = null;
    try {
      c = Class.forName("com.msunsoft.reflection.Foo2");
    } catch (Exception e) {
      e.printStackTrace();
    }
    Foo2 f1 = null;
    Foo2 f2 = null;
    //获取所有的构造方法
    Constructor<?> cons[] = c.getConstructors();
    try {
      f1 = (Foo2) cons[0].newInstance();
      f2 = (Foo2) cons[1].newInstance("abc");
      f1.print();
      f2.print();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
