package solutions;

/*
 * 3040. 相同分数的最大操作数目 II
 *       https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description
 *
 * */
public class Solution3040 {
    public Solution3040() {}
    public static int maxOperations(int[] nums) {
        // 将整数数组 int[] 转换为linkedList
        // 先将nums[]转换为intStream，然后调用boxed()将其打包为Integer，再调用collect方法将其转为集合
//        LinkedList<Integer> nums_list = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));

        int fixed_score;
        int start;
        int end;
        // fixed case 1:
        fixed_score = nums[0] + nums[nums.length - 1];
        start = 1;
        end = nums.length - 2;
        int pace1 = 1;
        while(start < end && start + 1 < nums.length && end - 1 >= start){
            int temp_ff = nums[start] + nums[start + 1];
            int temp_fe = nums[start] + nums[end];
            int temp_ee = nums[end] + nums[end - 1];
            if(temp_ff == fixed_score) {
                start += 2;
                pace1 += 1;
            }else if(temp_fe == fixed_score) {
                start += 1;
                end -= 1;
                pace1 += 1;
            }else if(temp_ee == fixed_score) {
                end -= 2;
                pace1 += 1;
            }else {
                break;
            }
        }
        // fixed case 2:
        fixed_score = nums[0] + nums[1];
        start = 2;
        end = nums.length - 1;
        int pace2 = 1;
        while(start < end && start + 1 < nums.length && end - 1 >= start){
            int temp_ff = nums[start] + nums[start + 1];
            int temp_fe = nums[start] + nums[end];
            int temp_ee = nums[end] + nums[end - 1];
            if(temp_ff == fixed_score) {
                start += 2;
                pace2 += 1;
            }else if(temp_fe == fixed_score) {
                start += 1;
                end -= 1;
                pace2 += 1;
            }else if(temp_ee == fixed_score) {
                end -= 2;
                pace2 += 1;
            }else {
                break;
            }
        }
        // fixed case 3:
        fixed_score = nums[nums.length - 2] + nums[nums.length - 1];
        start = 1;
        end = nums.length - 3;
        int pace3 = 1;
        while(start < end && start + 1 < nums.length && end - 1 >= start){
            int temp_ff = nums[start] + nums[start + 1];
            int temp_fe = nums[start] + nums[end];
            int temp_ee = nums[end] + nums[end - 1];
            if(temp_ff == fixed_score) {
                start += 2;
                pace3 += 1;
            }else if(temp_fe == fixed_score) {
                start += 1;
                end -= 1;
                pace3 += 1;
            }else if(temp_ee == fixed_score) {
                end -= 2;
                pace3 += 1;
            }else {
                break;
            }
        }
        return Math.max(pace1, Math.max(pace2,pace3));
     }
}