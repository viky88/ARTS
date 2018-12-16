package com.viky.leetcode;


import org.junit.Test;

import java.util.*;


public class Leetcode_0003_longest_substring_without_repeating_character {

    @Test
    public void TestSet() {
        Set set = new LinkedHashSet<Character>();
        System.out.println(set.add('A'));
        System.out.println(set.add('B'));
        System.out.println(set.add('C'));
        System.out.println(set.add('D'));
        System.out.println(set.add('B'));
    }

    @Test
    public void TestEmpty() {
        String str = "";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void TestEmpty2() {
        String str = " ";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test2Char() {
        String str = "au";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test1() { //3
        String str = "abcabcbb";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test2() {
        String str = "bbbbb";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test3() {
        String str = "pwwkew";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test4() {
        String str = "pww";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    @Test
    public void Test5() {
        String str = "abcabcdefjhigklmn";
        Solution solution = new Solution();

        int result = solution.lengthOfLongestSubstring1(str);
        System.out.println(result);
    }

    /**
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    class Solution {

        /**
         * 滑动窗口方式：
         * [leftIndex,rightIndex]
         * 开始leftIndex不动，rightIndex往右移动，并将值添加到set中。
         * 如果添加成功，次数计算 Math.max(maxLength,rightIndex-leftIndex)，（注意：此时的rightIndex已经++）。
         * 如果添加失败，说明已经存在，从leftIndex开始移除，直到添加再次成功，说明set重复值之前的数据已经全部删除。
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring1(String s) {
            int maxLength = 0;
            Set<Character> set = new HashSet();
            int length = s.length();
            for (int leftIndex = 0, rightIndex = 0; rightIndex < length && leftIndex < length; ) {
                if (set.add(s.charAt(rightIndex))) {
                    rightIndex++;
                    maxLength = Math.max(maxLength, rightIndex - leftIndex);
                } else {
                    set.remove(s.charAt(leftIndex++));
                }
            }
            return maxLength;
        }

        /**
         * 字符串：ABCDECDEFGIF
         * A
         * AB
         * ABC
         * ABCD
         * ABCDE
         * ABCDEC  => ABCDE DEC  maxLength = 5;
         * DECD    => DEC ECD    maxLength = 5;
         * ECDE    => ECD CDE    maxLength = 5;
         * CDEF
         * CDEFG
         * CDEFGI
         * CDEFGIF => CDEFGI GIF  maxLength = 6;
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int maxLength = 0;
            Set<Character> set = new LinkedHashSet();
            Set<Character> tmpSet;
            int length = s.length();
            Boolean isEqual;
            for (int index = 0; index < length; index++) {
                char c = s.charAt(index);
                if (!set.add(c)) {
                    maxLength = Math.max(maxLength, set.size());
                    tmpSet = new LinkedHashSet();
                    isEqual = false;
                    for (char ch : set) {
                        if (ch == c) {
                            isEqual = true;
                            continue;
                        }
                        if (isEqual) {
                            tmpSet.add(ch);
                        }
                    }
                    tmpSet.add(c);
                    set = tmpSet;
                }
            }
            maxLength = Math.max(maxLength, set.size());
            return maxLength;
        }

        public int lengthOfLongestSubstring3(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }

    }

}
