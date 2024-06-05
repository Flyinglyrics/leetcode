package solutions;
/*
* 1103. 分糖果 II
*       https://leetcode.cn/problems/distribute-candies-to-people
* 思路：
*    1.先一轮一轮的发糖果，检查糖果够不够发一轮的，够的话继续，不够的话则中止整轮发放：
*           要发满一轮糖果需要的数目是 : (num_people * turn * ( num_people * turn + 1)) / 2;
*           turn为发放的轮数。
*    2.当糖果不够发一轮时，就从一号小朋友开始一个个发，直到糖果耗尽，则结束。
*
* 执行结果:
*       执行用时： 0ms，击败100% java;
*       执行内存：40.25mb，击败12.50% java；
* */
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int candies_needed = (num_people * (num_people + 1)) / 2;
        int[] result = new int[num_people];
        int accumulation = 0;
        int turn = 1;
        while(candies >= candies_needed) {
            for(int i = 0;i < num_people; i++) {
                result[i] += i + 1 + accumulation;
            }
            turn += 1;
            accumulation += num_people;
            candies_needed = (num_people * turn * ( num_people * turn + 1)) / 2;
        }
        turn -= 1;
        int candies_left = candies - (num_people * turn * ( num_people * turn + 1)) / 2;;
        int j = 0;
        while(candies_left > 0) {
            result[j] += Math.min(candies_left, (accumulation + 1));
            candies_left -= (accumulation + 1);
            accumulation += 1;
            j += 1;
        }
        return result;
    }
}
