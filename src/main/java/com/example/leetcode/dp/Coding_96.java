package com.example.leetcode.dp;

/**
 * @author: kai·yang
 * @Date: 2024/3/28 14:35
 * @Description:
 *
 * LeetCode: 【96】不同的二叉搜索树
 * Difficulty：medium
 * <link> https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class Coding_96 {

    public static int numTrees(int n) {
        return dfs(1, n);
    }


    /**
     * 深度优先遍历
     *
     *  给定一个有序序列 1.....n，为了构建出一棵二叉搜索树，可以遍历每一个元素 i，
     *   将该数字当作根节点root，
     *   将 1....(n - 1)序列作为左子树
     *   将 (n + 1) ... n 序列作为右子树
     *  可以按照同样的方式递归构建左子树和右子树
     *  由于根的不同，因此能够保证构建的二叉搜索树是唯一的
     *
     * @param start
     * @param end
     * @return
     */
    public static int dfs(int start, int end){
        if (start > end){
            return 1;
        }
        int count = 0;
        //每个元素 当作 跟 节点构造出二叉搜索树
        for (int i = start; i <= end; i++ ){
            //左子树数量
            int left = dfs(start, i - 1);
            //右子树数量
            int right = dfs( i + 1, end);
            //两者 乘积 就是能构造出 多少种 二叉搜索树
            count += left * right;
        }
        return count;
    }


    /**
     * 动态规划
     *  给定一个有序序列 1.....n，为了构建出一棵二叉搜索树，可以遍历每一个元素 i，
     *  将该数字当作根节点root，
     *  将 1....(n - 1)序列作为左子树
     *  将 (n + 1) ... n 序列作为右子树
     * 可以按照同样的方式递归构建左子树和右子树
     * 由于根的不同，因此能够保证构建的二叉搜索树是唯一的
     * 原问题可以分解成规模较小的两个子问题，且子问题的解可以复用
     *
     *
     * @return
     */
    public static int numTreesDP(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //以长度为 L 构造的二叉搜索树
        for (int L = 2; L <= n; L++){
            for (int root = 1; root <= L; root++){
                //dp[root - 1] 相当于 以 root 为根节点 左子树的数量
                //dp[L - root] 相当于 以 root 为根节点 右子树的数量
                dp[L] += dp[root - 1] * dp[L - root];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        //动态规划
        System.out.println(numTreesDP(18));
        //深度优先
        System.out.println(numTrees(18));
    }

}
