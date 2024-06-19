package com.itheima.myalgorithm.dataStructure;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author 李鸿儒
 * @Description 单向链表
 * @date 2024/6/19 9:22
 * @Version 1.0
 */
public class SinglyLinkedList implements Iterable<Integer> { // 整体
    // 头指针
    private Node head = null;

    /**
     * 遍历器
     * 
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // 指针变量
            SinglyLinkedList.Node p = head;

            @Override
            public boolean hasNext() { // 查看是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() { // 返回当前元素，并且指针向下一个元素移动
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    /**
     * 向链表头部添加
     * 
     * @param value 添加元素的值
     */
    public void addFirst(int value) {
        // 链表为空 or 非空
        head = new Node(value, head);
    }

    /**
     * 向链表尾部添加
     * 
     * @param value 添加元素的值
     */
    public void addLast(int value) {
        Node last = findLast();
        // 链表为空
        if (findLast() == null) {
            addFirst(value);
            return;
        }
        // 链表非空
        last.next = new Node(value, null);
    }

    /**
     * 寻找链表中最后一个元素
     * 
     * @return 若找到返回 Node , 链表为空返回 null
     */
    private Node findLast() {
        // 1.链表为空
        if (head == null) {
            return head;
        }

        // 2.链表非空
        Node p;
        for (p = head; p.next != null; p = p.next) {

        }
        return p;
    }

    /**
     * 遍历链表 Consumer
     * 
     * @param consumer
     */
    public void loop1(Consumer<Integer> consumer) {
        // 遍历指针
        Node p = head;
        // 当指针没有指向最后一个元素的后一个 null 时继续遍历
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表 Consumer for循环
     * 
     * @param consumer
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        /**
         * static 当内部类没有使用外部类的成员变量时，加上static
         */
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) { // 有参构造器
            this.value = value;
            this.next = next;
        }
    }
}
