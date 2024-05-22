package solutions;
import java.util.Stack;

public class Solution7 {
	/**
	 * 7. 整数反转
     *      https://leetcode.cn/problems/reverse-integer/description/
	 * 方法1：
	 * 思路：1.先用String.valueOf()数字转换为字符串，如果字符串首位是'-'，则标记其为负数，并且将符号截取。
	 *      2.使用StringBuilder.reverse()方法反转字符串。
	 *      3.使用Integer.parseInt()方法将字符串转换为整数。考虑到边界情况，使用try catch语句，转换失败时返回0值；
	 * 结果：
	 *		执行用时：1ms,超越36.88%Java用户
	 *      消耗内存：40.20mb,击败8，92%java用户
	 */
    public static int reverse(int x) {
        String s = String.valueOf(x);
        boolean isNegative = false;
        if (s.charAt(0) == '-'){
            s = s.substring(1,s.length());
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder(s);
        String re = sb.reverse().toString();
        int value = 0;
        try {
            value = Integer.parseInt(re);
        } catch (NumberFormatException e) {
            ;
        }
        if(isNegative) {
            value = -value;
        }
        return value;
    }
    /**
     * 方法2：用栈来做字符串反转：
     * 结果：
     *     执行用时：3ms,超越8.54%Java用户
	 *     消耗内存：40.28mb,击败6，86%java用户
	 * 更慢了。
     * 
     */
    public static int reverse2(int x) {
        String s = String.valueOf(x);
        Stack<Character> stack = new Stack<Character>();
        boolean isNegative = false;
        for(int i = 0;i < s.length();i ++) {
        	if(i == 0 && s.charAt(i) == '-') {
        		isNegative = true;
        	}else {
        		stack.push(s.charAt(i));
        	}
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop());
        }
        int value = 0;
        try {
            value = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            ;
        }
        return isNegative? -value:value;
    }
}
