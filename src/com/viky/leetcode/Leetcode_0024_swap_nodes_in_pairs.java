package com.viky.leetcode;

import org.junit.Test;

public class Leetcode_0024_swap_nodes_in_pairs {

	@Test
	public void test1() {
		int[] arr = new int[]{1,2,3,4};
		ListNode listNode = ListNode.createByArray(arr);

		Solution solution = new Solution();
		ListNode result = solution.swapPairs1(listNode);
		System.out.println(result);

	}
	/**
	 * 
	 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
		给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

		示例:
		
		给定 1->2->3->4, 你应该返回 2->1->4->3.
		说明:
		
		你的算法只能使用常数的额外空间。
		你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

	    我们首先需要建立pre、node1、node2和lat四个指针即可
	    然后pre->next=node2;node2.next=node1;node1.next=lat
	    参考： https://blog.csdn.net/qq_17550379/article/details/80675453
	 *
	 */
	class Solution {
	    public ListNode swapPairs1(ListNode head) {
	    	ListNode h = new ListNode(-1);
	    	h.next = head;
	    	ListNode pre = h;
	    	ListNode node1 = null;
	    	ListNode node2 = null;
	    	ListNode lat = null;
	        while (pre.next !=null && pre.next.next !=null) {
				node1 = pre.next;
				node2 = node1.next;
				lat = node2.next;
			
				pre.next = node2;
				node2.next = node1;
				node1.next = lat;

				pre = node1;
				
			}
	        return h.next;
	    }
	}
}
