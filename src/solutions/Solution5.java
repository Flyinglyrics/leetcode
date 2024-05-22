package solutions;
/*
 * 5.最长回文子串：
 *   https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * 思路：如果 "aba" 是回文字符串，那么 "cabac" 也是回文字符串。
 *  所以:如果s.charAt(i) = s.charAt(i + 1) 或者s.charAt(i) = s.charAt(i + 2);
 *      那么这个回文子串增长的充要条件是:s.charAt(i - 1) = s.charAt(i + 2) 或者s.charAt(i - 1) = s.charAt(I + 3);
 * 结果：
 *  执行用时：19ms，击败75.34% java用户。
 *  内存：41.23mb，击败82.57% java用户。
 *  时间复杂度：这段Java代码的时间复杂度为 O(n^2)，其中 n 是字符串 s 的长度。这是因为在最坏的情况下，当字符串 s 本身是一个回文串时，方法需要比较每对可能的起始和结束索引，并且每次比较都需要 O(n) 的时间。因此，总时间复杂度为 O(n^2)。
 *  空间复杂度：空间复杂度为 O(1)，因为方法只使用了几个整数变量和一个字符串变量，它们都是常数大小的。方法没有创建任何与输入大小成正比的数据结构。
 */
public class Solution5 {
	private Solution5() {}

    public static String longestPalindrome(String s) {
    	int rangeLeft = 0;
    	int rangeRight = 0;
    	int length = 0;
    	for (int i = 0;i < s.length(); i ++) {
    		if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
    			int start = i;
        		int end1 = i + 1;
    			while (indexInRange(start,end1,s) && s.charAt(start) == s.charAt(end1)) {
        			if ((end1 - start) > length) {
        				rangeLeft = start;
            			rangeRight = end1;
            			length = end1 - start;
        			}
        			start -= 1;
        			end1 += 1;
        		}
    		}
    		if (i+2 < s.length()  && s.charAt(i) == s.charAt(i+2)) {
    			int start = i;
        		int end2 = i + 2;
    			while (indexInRange(start,end2,s) && s.charAt(start) == s.charAt(end2)) {
        			if ((end2 - start) > length) {
        				rangeLeft = start;
            			rangeRight = end2;
            			length = end2 - start;
        			}
        			start -= 1;
        			end2 += 1;
        		}
    		}
    	}
    	return s.substring(rangeLeft, rangeRight + 1);
    }
    static boolean indexInRange(int i, int j,String str) {
    	return i >= 0 && i < str.length() && j >= 0 && j < str.length();
    }
}