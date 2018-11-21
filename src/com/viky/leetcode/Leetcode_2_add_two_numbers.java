package com.viky.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
 

public class Leetcode_2_add_two_numbers {

	
	@Test
	public void test1() { 
		ListNode listNode1 = new ListNode(2);
		ListNode listNode1_Next1 = new ListNode(4);
		listNode1.next = listNode1_Next1;
		ListNode listNode1_Next2 = new ListNode(3);
		listNode1_Next1.next = listNode1_Next2; 
		
		ListNode listNode2 = new ListNode(5);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(4);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers1(listNode1, listNode2);
		System.out.println("结果：");
		System.out.println(listNode1);
		System.out.println("+");
		System.out.println(listNode2);
		System.out.println("=");
		System.out.println(result);
	}
	
	@Test
	public void test2() { 
		ListNode listNode1 = new ListNode(2);
		ListNode listNode1_Next1 = new ListNode(4);
		listNode1.next = listNode1_Next1;
//		ListNode listNode1_Next2 = new ListNode(3);
//		listNode1_Next1.next = listNode1_Next2; 
		
		ListNode listNode2 = new ListNode(5);
		listNode2.next = new ListNode(6);
		listNode2.next.next = new ListNode(4);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers1(listNode1, listNode2);
		System.out.println("结果：");
		System.out.println(listNode1);
		System.out.println("+");
		System.out.println(listNode2);
		System.out.println("=");
		System.out.println(result);
	}
	
	
	@Test
	public void test3() { 
		int[] arr1 = new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		ListNode listNode1 = createByArray(arr1);
		
		int[] arr2 = new int[]{5,4,6};
		ListNode listNode2 = createByArray(arr2);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers2(listNode1, listNode2);
		System.out.println("结果：");
		System.out.println(listNode1);
		System.out.println("+");
		System.out.println(listNode2);
		System.out.println("=");
		System.out.println(result);
	}
	@Test
	public void test4() { 
		int[] arr1 = new int[]{9,8,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		ListNode listNode1 = createByArray(arr1);
		
		int[] arr2 = new int[]{5,4,6};
		ListNode listNode2 = createByArray(arr2);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers2(listNode1, listNode2);
		System.out.println("结果：");
		System.out.println(listNode1);
		System.out.println("+");
		System.out.println(listNode2);
		System.out.println("=");
		System.out.println(result);
	}
	@Test
	public void test5() { 
		int[] arr1 = new int[]{9,8,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		ListNode listNode1 = createByArray(arr1);
		
		int[] arr2 = new int[]{5,4,6};
		ListNode listNode2 = createByArray(arr2);
		
		Solution solution = new Solution();
		ListNode result = solution.addTwoNumbers3(listNode1, listNode2);
		System.out.println("结果：");
		System.out.println(listNode1);
		System.out.println("+");
		System.out.println(listNode2);
		System.out.println("=");
		System.out.println(result);
	}
	public ListNode createByArray(int[] arr) {
		ListNode result = new ListNode(arr[0]); ;
		ListNode next = result;
		for(int i=1;i<arr.length;i++){  
			next.next = new ListNode(arr[i]);
			next = next.next; 
		}
		return result;
	}
	
	/**
	 * 
	 	给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 单位 数字。
		如果，我们将这两个数起来相加起来，则会返回出一个新的链表来表示它们的和。
		您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
		
		示例：
		输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
		输出：7 -> 0 -> 8
		原因：342 + 465 = 807
		
		https://leetcode-cn.com/problems/add-two-numbers/solution/
	 *
	 */
	class Solution {
		// 将链转为数字,相加后,将数字转为链 ,放弃
		public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
			// 将链转为数字
			long num1 = 0;
			if(l1 !=null){
				num1 = l1.val;
				int i = 0;
				ListNode next = l1.next; 
				while (next !=null) {
					i++;
					num1 += next.val * Math.pow(10, i);
					next = next.next;
				}
			}
			
			long num2 = 0;
			if(l2 !=null){
				num2 = l2.val;
				int j = 0;
				ListNode next = l2.next; 
				while (next !=null) {
					j++;
					num2 += next.val * Math.pow(10, j);
					next = next.next;
				}
			}
			System.out.println("num1="+num1);
			System.out.println("num2="+num2);
			
			long num3 = num1 + num2;
			System.out.println("num3="+num3);
			
			// 将数字转为链
			char[] arr = (num3+"").toCharArray();
			for(char c : arr){
				System.out.println(c);
			} 
			ListNode result = null;
			ListNode next = null;
			for(int i=arr.length-1;i>=0;i--){
				//System.out.println("arr["+i+"]="+arr[i]); 
				if(result==null){
					result = new ListNode(Character.getNumericValue(arr[i])); 
					next = result;
				}else{
					next.next = new ListNode(Character.getNumericValue(arr[i]));
					next = next.next;
				}
			}
			return result;
		}
		
		
		// 将链转为Collection,相加后，转回链表
		public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
			// 将链转为Collection
			List<Integer> list1 = new ArrayList<>();
			ListNode next1 = l1; 
			while (next1 !=null) { 
				list1.add(next1.val); 
				next1 = next1.next;
			}
			
			List<Integer> list2 = new ArrayList<>();
			ListNode next2 = l2; 
			while (next2 !=null) { 
				list2.add(next2.val); 
				next2 = next2.next;
			}
			
			Integer[] arr1 = list1.size()>list2.size() ? list1.toArray(new Integer[0]) : list2.toArray(new Integer[0]);
			Integer[] arr2 = list1.size()>list2.size() ? list2.toArray(new Integer[0]) : list1.toArray(new Integer[0]);
			
			Integer[] arr3 = new Integer[arr1.length+1];
			boolean isAdd = false;
			for(int i=0;i<arr3.length-1;i++){ 
				arr3[i] = arr1[i] + (i<arr2.length ? arr2[i] : 0);
				if(isAdd){
					arr3[i] = arr3[i] + 1 ;
					isAdd = false;
				}
				if(arr3[i]>=10){
					arr3[i] = arr3[i] % 10;
					isAdd = true;
				}
			}
			if(isAdd){
				arr3[arr3.length-1] = 1;
			}
			
			//System.out.println("arr1:"+ Arrays.toString(arr1));
		    //System.out.println("arr2:"+ Arrays.toString(arr2));
			//System.out.println("arr3:"+ Arrays.toString(arr3));
			
			
			ListNode result = new ListNode(arr3[0]); ;
			ListNode next = result;
			for(int i=1;i<arr3.length;i++){  
				if(arr3[i]!=null){
					next.next = new ListNode(arr3[i]);
					next = next.next; 
				}
			}
			return result;
		}
		
		public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
	        ListNode n1 = l1;
	        ListNode n2 = l2;
	        ListNode head = new ListNode(0);
	        ListNode current = head;
	        int temp = 0;
	        while(n1 != null || n2 != null) {
	            int a = n1 == null ? 0 : n1.val;
	            int b = n2 == null ? 0 : n2.val;
	            int sum = temp + a + b;
	            temp = sum / 10;
	            current.next = new ListNode(sum % 10);
	            current = current.next;
	            if(n1 != null) n1 = n1.next;
	            if(n2 != null) n2 = n2.next;
	        }
	        if(temp > 0) current.next = new ListNode(temp);
	        return head.next;
	    }
	}
	
	class ListNode {
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
		
	}
}
