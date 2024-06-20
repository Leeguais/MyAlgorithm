package com.itheima.myalgorithm;

import com.itheima.myalgorithm.dataStructure.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
		list.addLast(3); // index = 2
		list.addLast(4);

		Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);

		int i = list.get(2);
		System.out.println(i == 3);

		// int j = list.get(10); 索引不合法
		// System.out.println(j);

	}

	@Test
	@DisplayName("测试 insert")
	public void testInsert(){
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(4); // index = 2
		list.addLast(5);

		list.insert(2, 3);
		Assertions.assertIterableEquals(List.of(1,2,3,4,5), list);

		list.insert(0, 0);
		Assertions.assertIterableEquals(List.of(0,1,2,3,4,5), list);

		// 索引不合法
		// list.insert(10, 10);

	}

}
