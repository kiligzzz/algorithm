package type;

/**
 * 动态规划
 * 应用关键：
 * 1.最优子结构 -> 大小为n的问题的最优解可以由小于n的问题的同一实例的最优解推导出
 * 2.重叠子问题 -> 如斐波那契数列，即从第三项开始，每一项都等于前两项之和
 *
 * @author Ivan
 * @date 2023/2/27 16:45
 */
public interface DynamicProgramming {
    /**
     * 贪心
     * 最简单的动态规划
     */
    interface Greed {
    }

    /**
     * Kadane
     * 应用关键：求最大子数组和
     */
    interface Kadane extends DynamicProgramming {
        /**
         * 以下为默认格式
         */
        default int maxSubArray(int[] nums) {
            int pre = 0;
            int res = nums[0];
            for (int num : nums) {
                pre = num + Math.max(pre, 0);
                res = Math.max(pre, res);
            }
            return res;
        }
    }
}
