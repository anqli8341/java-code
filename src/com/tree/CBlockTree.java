/**
 * 
 */
package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author anquan li
 *
 */
public class CBlockTree {

  // 子节点
  List<Node> child;

  // 根节点（自己设定一些特殊的表示）
  Node       root;
  // 左上角
  Point      postion;
  // 宽度
  double     width      = 0d;
  // 长度
  double     height     = 0d;
  List<Node> returnList = new ArrayList<Node>();

  // 向树中插入一个节点
  public void insert(long value) {
    Node newNode = new Node(postion, width, height);
    // 树是空的
    if (root == null)
      root = newNode;
    else {
      Node current = root;
      Node parentNode;
      while (true) {
        parentNode = current;
        if (value < current.value) {
          current = current.leftChild;
          // 要插入的节点为左孩子节点
          if (current == null) {
            parentNode.leftChild = newNode;
            return;
          }
        } else {
          // 要插入的节点为右孩子节点
          current = current.rightChild;
          if (current == null) {
            parentNode.rightChild = newNode;
            return;
          }
        }
      }
    }
  }

  // 根据节点名称得到节点
  public List<Node> getChildNodes(List<Node> list,
                                  String name) {

    if (list == null && name == null)
      return null;
    for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
      Node node = (Node) iterator.next();
      // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
      if (name.equals(node.name)) {
        recursionFn(list, node);
      }

    }
    return returnList;
  }

  public String getChildNodesStr(List<Node> list,
                                 String name) {
    if (list == null && name == null)
      return "";
    for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
      Node node = (Node) iterator.next();
      // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
      if (name.equals(node.name)) {
        recursionFn(list, node);
      }

    }
    return returnList.toString();
  }

  private void recursionFn(List<Node> list,
                           Node node) {
    List<Node> childList = getChildList(list, node);// 得到子节点列表
    if (hasChild(list, node)) {// 判断是否有子节点
      returnList.add(node);
      Iterator<Node> it = childList.iterator();
      while (it.hasNext()) {
        Node n = (Node) it.next();
        recursionFn(list, n);
      }
    } else {

      returnList.add(node);
    }
  }

  public boolean hasChild(List<Node> list,
                          Node node) {
    return getChildList(list, node).size() > 0 ? true : false;
  }

  public List<Node> getChildList(List<Node> list,
                                 Node node) {
    List<Node> nodeList = new ArrayList<Node>();
    Iterator<Node> it = list.iterator();
    while (it.hasNext()) {
      Node n = (Node) it.next();
      if (n.parent.id == node.id) {
        nodeList.add(n);
      }
    }
    return nodeList;
  }
}

// 节点树形结构
class Node {

  int               id;

  String            name;

  // 左上角
  Point             postion;
  // 宽度
  double            width  = 0d;
  // 长度
  double            height = 0d;
  // 子节点
  public List<Node> Child;
  // 父节点
  public Node       parent;
  // 第几层
  public int        level;
  public long       value;

  public Node       leftChild;

  public Node       rightChild;

  public Node(Point Postion, double width, double height) {
    this.postion = Postion;
    this.width = width;
    this.height = height;
  }

  // 获取范围
  public Range getRange() {
    return new Range(postion, width, height);
  }

  // 获取面积
  public double getAcreage() {
    return width * height;
  }

}

// 位置坐标
class Point {

  double x = 0d;
  double y = 0d;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
}

// 范围
class Range {
  // 上下左右四个点
  Point left_up;
  Point right_up;
  Point left_down;
  Point right_down;

  // 设定范围
  public Range(Point postion, double width, double height) {
    left_up = postion;
    left_down = new Point(postion.x, postion.y + height);
    right_up = new Point(postion.x + width, postion.y);
    right_down = new Point(postion.x + width, postion.y + height);
  }
}
