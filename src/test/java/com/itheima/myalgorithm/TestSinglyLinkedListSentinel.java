package com.itheima.myalgorithm;

import com.itheima.myalgorithm.dataStructure.SinglyLinkedListSentinel;
import com.itheima.myalgorithm.dataStructure.SinglyLinkedListSentinel;
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
public class TestSinglyLinkedListSentinel{

	private SinglyLinkedListSentinel getLinkedList(){
		SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		return list;
	}

	@Test
	public void testLoop() {
		SinglyLinkedListSentinel list = getLinkedList();


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
		SinglyLinkedListSentinel list = getLinkedList();


		for (Integer value : list) {
			System.out.println(value);
		}
	}


	@Test
	@DisplayName("测试 addFirst")
	public void testAddFirst(){
		SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
		// 链表为空
		list.addFirst(10);
		Assertions.assertIterableEquals(List.of(10), list);
		// 链表非空
		list = getLinkedList();
		list.addFirst(0);
		Assertions.assertIterableEquals(List.of(0,1,2,3,4), list);
	}

	@Test
	@DisplayName("测试 addLast")
	public void testAddLast() {
		SinglyLinkedListSentinel list = getLinkedList();

		Assertions.assertIterableEquals(List.of(1, 2, 3, 4), list);

		int i = list.get(2);
		System.out.println(i == 3);

		// int j = list.get(10); 索引不合法
		// System.out.println(j);

	}

	@Test
	@DisplayName("测试 insert")
	public void testInsert(){
		SinglyLinkedListSentinel list = getLinkedList();
		/*
		list = 1,2,3,4
		index  0 1 2 3
		 */

		// 头部插入
		list.insert(0, 5);
		Assertions.assertIterableEquals(List.of(5,1,2,3,4), list);

		// 中间插入
		list = getLinkedList();
		list.insert(2, 5);
		Assertions.assertIterableEquals(List.of(1,2,5,3,4), list);

		//尾部插入
		list = getLinkedList();
		list.insert(3, 5);
		Assertions.assertIterableEquals(List.of(1,2,3,5,4), list);

		// 索引不合法
		Assertions.assertThrows(IllegalArgumentException.class,
								() -> getLinkedList().insert(10, 10));
	}
	@Test
	@DisplayName("测试 removeFirst")
	public void testRemovFirst(){
		SinglyLinkedListSentinel list = getLinkedList();

		list.removeFirst();
		Assertions.assertIterableEquals(List.of(2,3,4), list);
		list.removeFirst();
		Assertions.assertIterableEquals(List.of(3,4), list);
		list.removeFirst();
		Assertions.assertIterableEquals(List.of(4), list);
		list.removeFirst();
		Assertions.assertIterableEquals(List.of(), list);
		// 链表为空继续删除 抛出异常
		Assertions.assertThrows(IllegalArgumentException.class, list :: removeFirst);
	}

	@Test
	@DisplayName("测试 removeIndex")
	public void testRemoveIndex(){
		SinglyLinkedListSentinel list = getLinkedList();
		/*
		list   1,2,3,4
		index  0,1,2,3
		 */

		// 头部删除
		list.removeIndex(0);
		Assertions.assertIterableEquals(List.of(2,3,4), list);
		// 中间删除
		list = getLinkedList();
		list.removeIndex(2);
		Assertions.assertIterableEquals(List.of(1,2,4), list);
		// 尾部删除
		list = getLinkedList();
		list.removeIndex(3);
		Assertions.assertIterableEquals(List.of(1,2,3), list);
		// 删除索引不合法
		Assertions.assertThrows(IllegalArgumentException.class, () -> getLinkedList().removeIndex(-2));
	}

	@Test
	@DisplayName("测试 get")
	public void testGet(){
		SinglyLinkedListSentinel list = getLinkedList();

		System.out.println(list.get(1));

	}




}
