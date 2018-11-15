/**
 * 
 */
package com.msunsoft.reflection;

import java.lang.reflect.Array;

/**
 * @author anquan li
 * 
 * 修改数组大小
 *
 */
public class ReflectionHelloWorld4 {

  /**
   * 
   */
  public ReflectionHelloWorld4() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] intArray = { 1, 2, 3, 4, 5 };
    int[] newIntArray = (int[]) changeArraySize(intArray, 10);
    print(newIntArray);

    String[] str = { "a", "b", "c", "d", "e" };
    String[] str1 = (String[]) changeArraySize(str, 10);
    print(str1);

  }

  private static void print(Object obj) {
    // TODO Auto-generated method stub
    Class<?> c = obj.getClass();
    if (!c.isArray()) {
      return;
    }
    System.out.println("\nArray length: " + Array.getLength(obj));

    for (int i = 0; i < Array.getLength(obj); i++) {
      System.out.print(Array.get(obj, i) + " ");
    }

  }

  /**
   * 修改数组大小
   * 
   * @param obj
   * @param i
   * @return
   */
  private static Object changeArraySize(Object obj,
                                        int len) {
    // TODO Auto-generated method stub
    Class<?> arr = obj.getClass().getComponentType();
    Object newArray = Array.newInstance(arr, len);

    // 复制数组
    int co = Array.getLength(obj);
    System.arraycopy(obj, 0, newArray, 0, co);
    return newArray;
  }

}
