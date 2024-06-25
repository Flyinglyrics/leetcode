package solutions;
/*
 * 3038. 相同分数的最大操作数目 I
 *       https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/
 *
 * 结果：
 *      ① 执行用时：0ms，击败98.32% java user；
 *      ② 消耗内存：40.99mb,击败 9.90% Java user；
 *
 * */
public class Solution3038 {
    public Solution3038() {}
    public static int maxOperations(int[] nums) {
        int paces = 0;
        if(nums.length < 2) return paces;
        int fixed_score = nums[0] + nums[1];
        paces += 1;
        int nums_starter = 2;
        while (nums_starter + 1 < nums.length) {
            int temp_score = nums[nums_starter] + nums[nums_starter + 1];
            if (temp_score != fixed_score) break;
            nums_starter += 2;
            paces += 1;
        }
        return paces;
    }
}
