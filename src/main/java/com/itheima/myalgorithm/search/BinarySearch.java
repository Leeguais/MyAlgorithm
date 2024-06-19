package search;

import java.util.Arrays;

/**
* @Author: 李鸿儒
* @CreateTime: 2024-06-05
* @Description: 二分查找
* @Version: 1.1
*/
public class BinarySearch {



	//调用方法
	public static void main(String[] args) {

		int[] arr = {11,22,33,44,55};
		String arrString = Arrays.toString(arr);

		int target = 55;

		System.out.println("当前数组：" + arrString + ",目标数据为：" + target);
		System.out.println("二分查找后结果为：" + binarySearchBasic(arr, target));
	}


	/**
	 * 二分查找基础版
	 * @param arr 待查询的已排序数组
	 * @param target 待查询的值
	 * @return 如果找到值返回对应索引，若没找到返回 -1
	 */
	public static int binarySearchBasic(int[] arr , int target){

		/*
		* Version 1.1
		* (i + j) / 2  ----->  (i + j) >>> 1
		* 无符号右移：整数右移一位，结果为除以二并向下取整
		* */

		int i = 0;
		int j = arr.length - 1;
		int targetIndex = -1;

		// 左右边界中间还有值
		while (i <= j){
			int middle = (i + j) >>> 1 ;
			if (arr[middle] < target){        // 目标在右侧
				i = middle + 1;
			} else if (target < arr[middle]){ // 目标在左侧
				j = middle - 1;
			} else {                          // 目标正好是中间值所在处
				targetIndex = middle;
				return targetIndex;
			}
		}
		return targetIndex;
	}
	/**
	 * 二分查找 Leftmost
	 * @param arr 待查找的升序数组
	 * @param target 待查找的目标值
	 * @return 找到则返回索引 , 找不到返回 -1
	 */
	public static int binarySearchLeftmost_1(int[] arr , int target){


		int i = 0;
		int j = arr.length - 1;
		int candidate = -1; // candidate 候选者
		int targetIndex;

		// 左右边界中间还有值
		while (i <= j){
			int middle = (i + j) >>> 1 ;
			if (arr[middle] < target){        // 目标在右侧
				i = middle + 1;
			} else if (target < arr[middle]){ // 目标在左侧
				j = middle - 1;
			} else {                          // 目标正好是中间值所在处
				candidate = middle;
				j = middle - 1;
			}
		}
		targetIndex = candidate;
		return targetIndex;
	}
}
