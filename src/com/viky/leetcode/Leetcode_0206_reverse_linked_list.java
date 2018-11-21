package com.viky.leetcode; 

import java.io.Console;
import java.util.Currency;

import org.junit.Test;
  
public class Leetcode_0206_reverse_linked_list {

	@Test
	public void test1() {
		int[] arr = new int[]{1,2,3,4,5};
		ListNode listNode = ListNode.createByArray(arr);
		
		Solution solution = new Solution();
		ListNode result = solution.reverseList1(listNode);
		System.out.println(result);
	}
	@Test
	public void test2() {
		int[] arr = new int[]{0,1,2,3,4,5};
		ListNode listNode = ListNode.createByArray(arr);
		
		Solution solution = new Solution();
		ListNode result = solution.reverseList1(listNode);
		System.out.println(result); 
	}
	
	@Test
	public void test3() {
		int[] arr = new int[]{0,1,2,3,4,5,6};
		ListNode listNode = ListNode.createByArray(arr);
		
		Solution solution = new Solution(); 
		
		ListNode result = solution.reverseList2(listNode);
		System.out.println(result);
	}
	@Test
	public void test4() {
		int[] arr = new int[]{0,1,2,3,4,5,6};
		ListNode listNode = ListNode.createByArray(arr);
		
		Solution solution = new Solution(); 
		
		ListNode result = solution.reverseList3(listNode);
		System.out.println(result);
	}

	/**
	 * 
	 	反转一个单链表。

		示例:
		
		输入: 1->2->3->4->5->NULL
		输出: 5->4->3->2->1->NULL
	 *
	 */
	class Solution {
	    public ListNode reverseList1(ListNode head) {
	    	if(head==null) {
	    		return null;
	    	}
	    	ListNode listNode = new ListNode(head.val);
	    	head = head.next;
	        while(head!=null) {
        		ListNode result = new ListNode(head.val);
        		result.next = listNode;
        		listNode = result;
        		head = head.next;
	        }
	        return listNode;
	    }
	    public ListNode reverseList2(ListNode head) {
	    	if(head==null) {
	    		return null;
	    	}
	    	ListNode pre = head;
	    	ListNode cur = head.next;
	    	ListNode temp;
	        while(cur != null) { 
        		temp = cur.next;
        		cur.next = pre;
        		pre = cur; 
	        	cur = temp;
	        }
	        head.next = null;
	        return pre;
	    }
	    
	    public ListNode reverseList3(ListNode head) {
	    	if(head==null) {
	    		return null;
	    	}
	    	ListNode result = new ListNode(head.val);
	    	ListNode cur = head.next;
	    	ListNode temp;
	        while(cur != null) { 
        		temp = cur.next;
        		cur.next = result;
        		result = cur; 
	        	cur = temp;
	        }
	        return result;
	    }
	}

}
