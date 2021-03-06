/**
 *
 */
package com.ds.Stack;

/**
 * Created by Abhishek Kumar
 * 2:21:38 PM Apr 23, 2012
 *
 * @Buffalo
 */
public class iStack {

  private Node top;
  private int count;

  public iStack() {
    top = null;
    count = 0;
  }

  public int size() {
    return count;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void push(Object data) {
    Node newNode = new Node(data);
    newNode.setNext(top);
    top = newNode;
    count++;
  }

  public Object pop() {
    if (top == null) {
      return null;
    }
    Object value = top.getData();
    top = top.getNext();
    count--;
    return value;
  }

  public Object peek() {
    return top.getData();
  }

  public void printer(Node top) {
    System.out.print("[ ");
    while (top != null) {
      System.out.print(top.getData() + " ");
      top = top.getNext();
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    iStack test = new iStack();
    test.push(1);
    test.push(2);

    test.push('a');
    test.push("data");
    System.out.println(test.size());
    System.out.println(test.peek());
    test.printer(test.top);
    test.pop();
    System.out.println(test.peek());
    test.printer(test.top);

    test.pop();
    test.printer(test.top);
    test.pop();
    test.printer(test.top);
  }
}

