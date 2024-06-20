package com.itheima.myalgorithm.dataStructure;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author 李鸿儒
 * @Description 单向链表(哨兵)
 * @date 2024/6/19 9:22
 * @Version 1.0
 */
public class SinglyLinkedListSentinel implements Iterable<Integer>{ // 整体
	// 头指针指向哨兵节点
	private Node head = new Node(666, null);


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
			// 指针变量起点
			Node p = head.next;

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
		insert(0, value);
	}

	/**
	 * 向链表尾部添加
	 *
	 * @param value 添加元素的值
	 */
	public void addLast(int value){
		Node last = findLast();

		// 链表若没有有效元素，在哨兵节点后直接加入新元素
		last.next = new Node(value, null);
	}

	/**
	 * 寻找链表中最后一个元素
	 *
	 * @return 若找到返回 Node , 链表为空返回 null
	 */
	private Node findLast(){
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
		// 遍历指针起点
		Node p = head.next;
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
		for(Node p = head.next; p != null; p = p.next){
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
		int i = -1;

		for(; p != null; p = p.next, i++){
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
		// 抛索引异常
		if(node == null){
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
		// 找到上一个节点
		Node prev = findNode(index - 1);
		if(prev == null){
			// 索引异常
			illegalIndex(index);
		}
		prev.next = new Node(value, prev.next);
	}


	/**
	 * 移除链表中第一个元素
	 */
	public void removeFirst(){
		removeIndex(0);
	}

	/**
	 * 从索引位置删除
	 * @param index 索引
	 */
	public void removeIndex(int index){
		Node prev = findNode(index - 1);
		if(prev == null){
			illegalIndex(index);
		}
		Node removed = prev.next;
		if(removed == null){
			illegalIndex(index);
		}
		prev.next = removed.next;
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
