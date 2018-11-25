package com.viky.leetcode;
 

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class Leetcode_0001_two_sum { 
	@Test
	public void Test1(){
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		Solution solution = new Solution();
		int[]  result1 = solution.twoSum1(nums, target);
		System.out.println(Arrays.toString(result1));
		
		int[]  result2 = solution.twoSum2(nums, target);
		System.out.println(Arrays.toString(result2));
		
		int[]  result3 = solution.twoSum3(nums, target);
		System.out.println(Arrays.toString(result3));
	}
	@Test
	public void Test2(){
		int[] nums = new int[]{3,2,4};
		int target = 6;
		Solution solution = new Solution();
		int[]  result1 = solution.twoSum1(nums, target);
		System.out.println(Arrays.toString(result1));
		
		int[]  result2 = solution.twoSum2(nums, target);
		System.out.println(Arrays.toString(result2));
		
		int[]  result3 = solution.twoSum3(nums, target);
		System.out.println(Arrays.toString(result3));
	}
	@Test
	public void Test3(){
		int[] nums = new int[]{3,5,5,2};
		int target = 10;
		Solution solution = new Solution();
		int[]  result1 = solution.twoSum1(nums, target);
		System.out.println(Arrays.toString(result1));
		
		int[]  result2 = solution.twoSum2(nums, target);
		System.out.println(Arrays.toString(result2));
		
		int[]  result3 = solution.twoSum3(nums, target);
		System.out.println(Arrays.toString(result3));
	}

	/**
	 *  https://leetcode-cn.com/problems/two-sum/solution/
	 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为gai目标值的 两个 整数。

	 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

	 示例:

	 给定 nums = [2, 7, 11, 15], target = 9
	 因为 nums[0] + nums[1] = 2 + 7 = 9
	 所以返回 [0, 1]
	 */
	class Solution {
		/**
		 * 方法一：暴力法
		 * 时间复杂度：O(n^2)， 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)。
		 * 空间复杂度：O(1)。
		 * @param nums
		 * @param target
		 * @return
		 */
		public int[] twoSum1(int[] nums, int target) {
			int[] result = null;
			int length = nums.length;
			if(length>=1){
				for(int i=0 ;i<length; i++){
					for(int j=i+1 ;j<length; j++){
						if(nums[i]+nums[j]==target){
							result = i< j ? new int[]{i,j} : new int[]{j,i};
							return result;
						}
					}
				}
			}
			return result;
		}
		/**
		 * 方法二：两遍哈希表
		 * 时间复杂度：O(n)， 我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1) ，所以时间复杂度为 O(n)。
		 * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素。
		 * @param nums
		 * @param target
		 * @return
		 */
		public int[] twoSum2(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				map.put(nums[i], i);
			}
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement) && map.get(complement) != i) {
					return new int[] { i, map.get(complement) };
				}
			}
			throw new IllegalArgumentException("No two sum solution");
		}
		/**
		 * 方法三：一遍哈希表
		 * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
		 * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
		 * @param nums
		 * @param target
		 * @return
		 */
		public int[] twoSum3(int[] nums, int target) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				int complement = target - nums[i];
				if (map.containsKey(complement)) {
					return new int[] { map.get(complement), i };
				}
				map.put(nums[i], i);
			}
			throw new IllegalArgumentException("No two sum solution");
		}

	}

}
