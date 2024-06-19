package com.itheima.myalgorithm;


import dataStructure.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Author: 李鸿儒
 * @CreateTime: 2024-06-19
 * @Description: 单向链表测试类
 * @Version: 1.0
 */
public class TestSinglyLinkedList {

    @Test
    public void testLoop() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        list.loop1(value -> {
            System.out.println(value);
        });

        System.out.println("-------------");

        list.loop2(value -> {
            System.out.println(value);
        });
    }

    @Test
    public void testForEachByIterable() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void testAddLast() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Assertions.assertIterableEquals(List.of(1,2,3,4), list);
    }

}
