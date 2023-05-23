package type;

/**
 * 动态规划
 *
 * @author Ivan
 * @date 2023/2/27 16:45
 */
public interface DynamicProgramming {
    /**
     * 贪心算法，最简单的动态规划
     */
    interface Greed {
    }

    /**
     * Kadane算法
     */
    interface Kadane extends DynamicProgramming {
        /**
         * 基于动态规划，主要用于解决最大子数组和问题
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
