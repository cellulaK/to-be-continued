package com.example.leetcode.dynamic;

/**
 * @author kai·yang
 * @Date 2023/7/31 17:12
 *
 * leetcode: 【746】 使用最小化非爬楼梯
 * level：easy
 * <link>https://leetcode.cn/problems/min-cost-climbing-stairs/
 */
public class Coding_746 {

    /**
     *给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付
     *  你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
     *  请你计算并返回达到楼梯顶部的最低花费。
     *
     *  示例 1：
     *
     * 输入：cost = [10,15,20]
     * 输出：15
     * 解释：你将从下标为 1 的台阶开始。
     * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
     * 总花费为 15 。
     *
     *  示例 2：
     *
     * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
     * 输出：6
     * 解释：你将从下标为 0 的台阶开始。
     * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
     * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
     * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
     * 总花费为 6 。
     *
     *
     *  提示：
     *
     *  2 <= cost.length <= 1000
     *  0 <= cost[i] <= 999
     *
     *  Related Topics 数组 动态规划
     */

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        //第一次跳到 第一阶台阶 或第二阶台阶是不用支付费用，
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1]  + cost[i - 1],  + dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
