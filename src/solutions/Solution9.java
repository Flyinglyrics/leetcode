package solutions;

/**
 * 9. 回文数
 *      https://leetcode.cn/problems/palindrome-number/description/
 *
 * 思路：1.若x为整数，x % 10 可以取其个位数值
 *      2. ((x - x % 10) / 10) % 10 可以取其百位上的数值
 *      3.构建循环，循环中取x = (x - x % 10) / 10，当且仅当x > 0，循环继续。
 *      4.因为要取的是整数的倒序(回文)，因此要先算出整数数位10^n，然后在循环中将首先取出的个位数值乘以最高数位10^n，然后百位乘以10^(n-1)......
 * 结果：执行用时：5ms，击败69.32% java用户
 *      内存占用：42。94mb，击败52.45% java用户。
 * 思考：能否在一次循环中解决问题而不是先循环求数位？
 * */
public class Solution9 {
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x > 0 && x % 10 == 0)){
            return false;
        }
        if(x == 0) {
            return true;
        }
        int origin = x;
        int reverse = 0;
        int n = 1;
        while(origin / 10 != 0) {
            origin /= 10;
            n *= 10;
        }
        origin = x;
        boolean flag = true;
        while (flag) {
           reverse += (origin % 10) * n;
           origin = (origin - origin % 10) / 10;
           n /= 10;
           flag = origin > 0;
        }
        return reverse == x;
    }
}