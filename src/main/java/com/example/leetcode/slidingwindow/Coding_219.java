package com.example.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: kai·yang
 * @Date: 2024/3/22 16:34
 * @Description:
 *
 * LeetCode: 【219】存在重复元素
 * Difficulty：easy
 * <link> https://leetcode.cn/problems/contains-duplicate-ii/description/
 */
public class Coding_219 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i- j) <= k 。如果存在，返回 true ；否则，返回 false 。
     *
     *  示例 1：
     *
     * 输入：nums = [1,2,3,1], k = 3
     * 输出：true
     *  示例 2：
     *
     * 输入：nums = [1,0,1,1], k = 1
     * 输出：true
     *  示例 3：
     *
     * 输入：nums = [1,2,3,1,2,3], k = 2
     * 输出：false
     *
     *
     *  提示：
     *
     *  1 <= nums.length <= 105
     *  -109 <= nums[i] <= 109
     *  0 <= k <= 105
     *
     *  Related Topics 数组 哈希表 滑动窗口
     *  👍 693 👎 0
     */

    /**
     * 滑动窗口
     * 思路： 两个元素下标的绝对值要 <= k,  所以一个滑动窗口的元素不超过 k + 1 个，满足任意两个元素小标差的绝对值不超过k，如果存在要给滑动窗口
     *       其中有重复元素，则存在 两个不同下标 i 和 j 满足 nums[i] = nums[j] 且 |i - j| <= k,如果滑动窗口中没有重复的元素，则不符合要求
     *
     *       如果一个滑动窗口的结束下标为 i，则该滑动窗口开始的下标是 max(0, i - k),用哈希标保存滑动窗口的元素，从左到右遍历 nums
     *       滑动窗口每向右移动一位，左边就要移除一位
     *       1、如果 i > k 则下标 i - k - 1处的元素被移出窗口，降nums[ i - k - 1]从哈希表中删除
     *       2、判断 nums[i] 是否存在哈希表中，如果存在返回true，如果不存在则将元素加入 哈希表中
     *       3、遍历结束时如果滑动窗口都没有重复元素，则返回false
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 ){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            //滑动窗口每向右移动一位，左边就要移除一位
            //i 为滑动窗口的有边界，当 i == k 时窗口达到最大， i - k为窗口的左边界
            //所以i 向右移动一位，左边界向右移动一位，即要删除 i - k - 1 位元素
            if ( i > k){
                set.remove( nums[i - k - 1]);
            }
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
