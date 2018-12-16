package com.viky.leetcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class Leetcode_0004_median_of_two_sorted_arrays {

    @Test
    public void testDouble(){
        int a = 10;
        System.out.println(a/4);
        System.out.println((double)a/4);
        System.out.println(a/6);
        System.out.println((double)a/6);
    }

    @Test
    public void testEmpty() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(0d,result,0.0);
    }
    @Test
    public void testNull() {
        Solution solution = new Solution();
        int[] nums1 = null;
        int[] nums2 = null;
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(0d,result,0.0);
    }

    @Test
    public void testOneLength0_1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{3,4};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(3.5d,result,0.0);
    }
    @Test
    public void testOneLength0_1_1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{3,4,5};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(4.0d,result,0.0);
    }

    @Test
    public void testOneLength0_2() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(1.5d,result,0.0);
    }
    @Test
    public void testOneLength0_2_1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(1.0d,result,0.0);
    }
    @Test
    public void testOneLength0_2_2() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(2.0d,result,0.0);
    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(2d,result,0.0);
    }
    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(2.5d,result,0.0);
    }
    @Test
    public void testNoOdd1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2,5,7,9};
        int[] nums2 = new int[]{10,8,7,6,5};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(6.5d,result,0.0);
    }
    @Test
    public void testNoOdd2() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(1.5d,result,0.0);
    }
    @Test
    public void testDesc1() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{9,6,5,4};
        int[] nums2 = new int[]{6,5,4,3};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(5.0d,result,0.0);
    }
    @Test
    public void testMinus() {
        Solution solution = new Solution();
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{-1,-2};
        double result = solution.findMedianSortedArrays(nums1,nums2);
        Assert.assertEquals(-1.0d,result,0.0);
    }
    /**
     *   https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     *
         给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

         请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

         你可以假设 nums1 和 nums2 不会同时为空。

         示例 1:

         nums1 = [1, 3]
         nums2 = [2]

         则中位数是 2.0
         示例 2:

         nums1 = [1, 2]
         nums2 = [3, 4]

         则中位数是 (2 + 3)/2 = 2.5
     */
    class Solution {
        /**
         * 官方答案，没有给倒序处理方法，没有给一个正序一个倒序的方法
         * @param A
         * @param B
         * @return
         */
        public double findMedianSortedArrays1(int[] A, int[] B) {
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A; A = B; B = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j-1] > A[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && A[i-1] > B[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = B[j-1]; }
                    else if (j == 0) { maxLeft = A[i-1]; }
                    else { maxLeft = Math.max(A[i-1], B[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = B[j]; }
                    else if (j == n) { minRight = A[i]; }
                    else { minRight = Math.min(B[j], A[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }

        /**
         * 支持 ，两个都是正序，两个都是倒序，或者一个正序一个倒序
         * @param nums1
         * @param nums2
         * @return
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            double result= 0d;
            if(nums1==null){
                nums1 = new int[]{};
            }
            if(nums2==null){
                nums2 = new int[]{};
            }
            if(nums1.length==0 && nums2.length==0){ // 处理两个都是0的情况
                return result;
            }

            // 奇数/偶数  是否是奇数
            boolean isOdd = (nums1.length+nums2.length)%2 !=0;
            int medianIndex1 = isOdd ? (nums1.length+nums2.length)/2 : (nums1.length+nums2.length)/2 -1;
            int medianIndex2 = isOdd ? -1 : (nums1.length+nums2.length)/2;

            int[] nums3 = new int[isOdd ? medianIndex1+1 :medianIndex2+1];
            // 倒序，正序？？
            boolean nums1Asc = true;
            boolean nums2Asc = true;

            for(int i=0 ;i<nums1.length-1;i++){
                if(nums1[i]!=nums1[i+1]){
                    nums1Asc = nums1[i] < nums1[i+1];
                    break;
                }
            }
            for(int i=0 ;i<nums2.length-1;i++){
                if(nums2[i]!=nums2[i+1]){
                    nums2Asc = nums2[i] < nums2[i+1];
                    break;
                }
            }
            int i = nums1Asc ? 0 : nums1.length-1;
            int j = nums2Asc ? 0 : nums2.length-1;;
            int index =0;
            while ((nums1Asc ? i<nums1.length : i>=0) || (nums2Asc ? j<nums2.length : j>=0)){
                if((nums1Asc ? i<nums1.length : i>=0) && (nums2Asc ? j<nums2.length : j>=0)){
                    if(nums1[i]<nums2[j]){
                        nums3[index] = nums1[i];
                        i = nums1Asc ? i+1 : i-1;
                    }else{
                        nums3[index] = nums2[j];
                        j = nums2Asc ? j+1 : j-1;
                    }
                }else if(nums1Asc ? i<nums1.length : i>0){
                    nums3[index] = nums1[i];
                    i = nums1Asc ? i+1 : i-1;
                }else if(nums2Asc ? j<nums2.length : j>0){
                    nums3[index] = nums2[j];
                    j = nums2Asc ? j+1 : j-1;
                }
                if(isOdd ){
                    if(index == medianIndex1){
                        break;
                    }
                }else{
                    if(index == medianIndex2){
                        break;
                    }
                }
                index++;
            }

            if(isOdd ){
                result = (double)nums3[nums3.length-1];
            }else{
                result = ((double)nums3[nums3.length-1]+(double)nums3[nums3.length-2])/2;
            }
            return result;
        }
    }

}
