package com.example.leetcode.list.source;

/**
 * @author kai·yang
 * @Date 2022/4/11 16:47
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
