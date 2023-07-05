package com.example.leetcode.string;

import com.alibaba.fastjson2.JSON;

/**
 * @author kai·yang
 * @Date 2023/7/3 11:30
 *
 * leetcode:【541】反转字符串II
 * level：easy
 * <link> https://leetcode.cn/problems/reverse-string-ii/
 */
public class Coding_541 {

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     *
     *  如果剩余字符少于 k 个，则将剩余字符全部反转。
     *  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     *
     *  示例 1：
     *
     * 输入：s = "abcdefg", k = 2
     * 输出："bacdfeg"
     *
     *  示例 2：
     *
     * 输入：s = "abcd", k = 2
     * 输出："bacd"
     *
     *
     *  提示：
     *
     *  1 <= s.length <= 104
     *  s 仅由小写英文组成
     *  1 <= k <= 104
     *
     *  Related Topics 双指针 字符串
     */


    public static String reverseStr(String s, int k) {
        int len = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < len; i += 2*k){
            reverse(array, i, Math.min(i + k, len)  - 1);
        }
        return String.valueOf(array);
    }

    public static char[] reverse(char[] arr, int start, int end){
        while(start < end){
            char item = arr[start];
            arr[start] = arr[end];
            arr[end] = item;
            start++;
            end--;
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}