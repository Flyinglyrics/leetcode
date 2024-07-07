package solutions;
/*
 * 11. 盛最多水的容器
 *       https://leetcode.cn/problems/container-with-most-water/description/
 *
 * 思路：1. 双指针分别从数组头和尾开始遍历，每次只移动一个指针，计算当前的储水体积，如果大于已记录的最大体积则替换。
 *      2. 每次要移动的指针是height[p]小的那个。（为什么？）
 *         因为木桶效应的存在，高度不一的两块板形成容器，存储能力的上限是由高度较低的那一块板子确定的。
 *         因此移动height[p]小的那个指针，因为此时，以height[p]为边的容器体积已经不会存在更大的了
 * 结果：执行用时：4ms，击败65.21% java用户
 *      内存占用：55.78mb，击败94.17% java用户。
 * */
public class Solution11 {
    public Solution11() {}
    public static int maxArea(int[] height) {
        int max_volume = 0, left_pointer = 0, right_pointer = height.length - 1;
        while (left_pointer < right_pointer) {
            max_volume = Math.max(max_volume, Math.min(height[left_pointer],height[right_pointer]) * (right_pointer - left_pointer));
            if (height[left_pointer] <= height[right_pointer]) {
                left_pointer += 1;
            }else {
                right_pointer -= 1;
            }
        }
        return max_volume;
    }
}
