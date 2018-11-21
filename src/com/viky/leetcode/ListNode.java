package com.viky.leetcode;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		String result = "";
		ListNode next = this;
		while (next !=null) { 
			result += next.val;
			next = next.next;
		}
		return result;
	}
	
	public static ListNode createByArray(int[] arr) {
		ListNode result = new ListNode(arr[0]);
		ListNode next = result;
		for(int i=1;i<arr.length;i++){  
			next.next = new ListNode(arr[i]);
			next = next.next; 
		}
		return result;
	}
}
