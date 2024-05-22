package solutions;
/*
 * 4.寻找两个正序数组的中位数：
 *   https://leetcode.cn/problems/median-of-two-sorted-arrays/description/
 *
 * 思路:因为给定的是正序数组，所以只需要从头遍历即可。
 *  1.定义两个不同步的索引分别用来遍历给定的正序数组，一次只移动其中一个索引，总时间复杂度：m + n;
 *  2.因为最终求取的是中位数，所以可以取巧，遍历只进行到一半即可。
 * 结果：
 * 	执行用时：超越100%的java用户。
 *  内存：超越32.42%的java用户。
 */
public class Solution4{
	private Solution4() {}
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer = 0;
        int combLength = nums1.length + nums2.length;
        int[] comb = new int[combLength];
        int endFlag;
        if(combLength % 2 == 0) {
            endFlag = combLength / 2;
        }else {
            endFlag = (int)Math.floor(comb.length / 2.0);
        }
        while(pointer <= endFlag) {
            if (pointer1 == nums1.length && pointer2 < nums2.length) {
                comb[pointer] = nums2[pointer2];
                pointer2 ++;
            }else if (pointer2 == nums2.length && pointer1 < nums1.length){
                comb[pointer] = nums1[pointer1];
                pointer1 ++;
            }else {
                if(nums1[pointer1] >= nums2[pointer2]) {
                    comb[pointer] = nums2[pointer2];
                    pointer2 ++;
                }else{
                    comb[pointer] = nums1[pointer1];
                    pointer1 ++;
                }
            }
            pointer ++;
        }
        return combLength % 2 == 0 ? (comb[endFlag -1 ] + comb[endFlag]) / 2.0 : comb[endFlag];
    }
	
}