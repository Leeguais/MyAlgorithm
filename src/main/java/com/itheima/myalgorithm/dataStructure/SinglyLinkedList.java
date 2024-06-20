package com.itheima.myalgorithm.dataStructure;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author 李鸿儒
 * @Description 单向链表
 * @date 2024/6/19 9:22
 * @Version 1.0
 */
public class SinglyLinkedList implements Iterable<Integer>{ // 整体
	// 头指针
	private Node head = null;

	/**
	 * 索引异常
	 */
	private static void illegalIndex(int index){
		throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
	}

	/**
	 * 遍历器
	 */
	@Override
	public Iterator<Integer> iterator(){
		return new Iterator<Integer>(){
			// 指针变量
			SinglyLinkedList.Node p = head;

			@Override
			public boolean hasNext(){ // 查看是否有下一个元素
				return p != null;
			}

			@Override
			public Integer next(){ // 返回当前元素，并且指针向下一个元素移动
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
	public void addFirst(int value){
		// 链表为空 or 非空
		head = new Node(value, head);
	}

	/**
	 * 向链表尾部添加
	 *
	 * @param value 添加元素的值
	 */
	public void addLast(int value){
		Node last = findLast();
		// 链表为空
		if(findLast() == null){
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
	private Node findLast(){
		// 1.链表为空
		if(head == null){
			return head;
		}

		// 2.链表非空
		Node p;
		for(p = head; p.next != null; p = p.next){
		}
		return p;
	}

	/**
	 * 遍历链表 Consumer
	 *
	 * @param consumer
	 */
	public void loop1(Consumer<Integer> consumer){
		// 遍历指针
		Node p = head;
		// 当指针没有指向最后一个元素的后一个 null 时继续遍历
		while(p != null){
			consumer.accept(p.value);
			p = p.next;
		}
	}

	/**
	 * 遍历链表 Consumer for循环
	 *
	 * @param consumer
	 */
	public void loop2(Consumer<Integer> consumer){
		for(Node p = head; p != null; p = p.next){
			consumer.accept(p.value);
		}
	}

	/**
	 * 通过索引寻找元素
	 *
	 * @param index
	 * @return
	 */
	private Node findNode(int index){
		// 定义指针 , 索引起始点
		Node p = head;
		int i = 0;

		for(; p.next != null; p = p.next, i++){
			if(i == index){
				return p;
			}
		}

		// 没有找到
		return null;
	}

	/**
	 * 根据索引查找元素的值
	 *
	 * @param index 查找索引
	 * @return 元素的值，若未找到报错
	 */
	public int get(int index){
		Node node = findNode(index);
		if(node == null){
			// 抛索引异常
			illegalIndex(index);
		}
		return node.value;
	}

	/**
	 * 向索引位置插入
	 *
	 * @param index 待插入处的索引
	 * @param value 待插入值
	 */
	public void insert(int index, int value){
		// 索引为0
		if(index == 0){
			addFirst(value);
			return;
		}

		// 找到上一个节点
		Node prev = findNode(index - 1);
		if(prev == null){
			// 索引异常
			illegalIndex(index);
		}
		prev.next = new Node(value, prev.next);
	}


	/**
	 * 节点类
	 */
	private static class Node{
		/**
		 * static 当内部类没有使用外部类的成员变量时，加上static
		 */
		int value; // 值
		Node next; // 下一个节点指针

		public Node(int value, Node next){ // 有参构造器
			this.value = value;
			this.next = next;
		}
	}


}
