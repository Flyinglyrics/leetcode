package solutions;
/**
 * 8.字符串转换整数 (atoi)
 * 		https://leetcode.cn/problems/string-to-integer-atoi/description/
 * 思路：
 *  1.严格按照题目描述的过程
 * 结果：
 *  执行用时：2ms
 *  消耗内存：42mb
 *  不是很理想，考虑优化方法
 */
public class Solution8 {
	public static int myAtoi(String s) {
        String s_t = s.trim();
        if(s_t.length() == 0) {
            return 0;
        }
        int i = 0;
        int start = 0;
        boolean isNegative = false;
        if(s_t.charAt(i) == '-') {
        	isNegative = true;
        	start = 1;
        	i ++;
        }else if(s_t.charAt(i) == '+') {
        	start = 1;
        	i ++;
        }
        while (i < s_t.length() && isNumberize(s_t.charAt(i))) {
        	i++;
        }
        String valid = s_t.substring(start, i);
        int value = 0;
        if (valid.length() > 0) {
        	try {
            	value = isNegative? -Integer.valueOf(valid) : Integer.valueOf(valid);
            }
            catch(NumberFormatException e) {
            	value = isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        return value;
    }
    // 判断一个字符是不是数字
	public static boolean isNumberize(char c) {
		boolean isNumbered = false; 
		switch(c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': 
			isNumbered = true;
			break;
		}
		return isNumbered;
	}
}
/**
 * 初始做法，没有认真审题的结果。实现了一个从任意包含数字的字符串中提取数字的算法。
 * 思路：
 *   1.实现一个方法，将一个char类型的值作为输入，输出该char类型能不能转换为数字：isNumberiz();
 *   2.使用String.trim()方法，去除初始字符串两端的空格。然后开始遍历trim后的字符串。
 *   3.当遍历到数字时(isNumberiz())，记录其index位置，然后看一看其前面的是不是负号,记录下来。然后继续遍历，直到遍历到非数字char，记录其index位置，按照两个index截取字符串(trimed)substr。
 *   4.尝试用Integer.parseInt(substr)，如果失败，那原因只能是数值超过了int,设置为Integer.MAX_VALUE;
 */
class Solution8_dep {
	public static int myAtoi(String s) {
        String s_t = s.trim();
        int i = 0;
        boolean isNegative = false;
        while(i < s_t.length() && !isNumberize(s_t.charAt(i))){
            i ++;
        }
        if(i - 1 >= 0 && s_t.charAt(i-1) == '-') {
        	isNegative = true;
        }
        int j = i;
        while(j < s_t.length() && isNumberize(s_t.charAt(j))) {
        	j ++;
        }
        String valid = s_t.substring(i,j);
        int value = 0;
        try {
        	value = Integer.parseInt(valid);
        }
        catch(NumberFormatException e) {
        	value = Integer.MAX_VALUE;
        }
        return isNegative? -value : value;
    }
	// 一个常规的判断对象能不能转换成数字的办法
    public static boolean isNumber (Object obj) {
        if (obj instanceof Number) {
            return true;
        } else if (obj instanceof String){
            try{
                Double.parseDouble((String)obj);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
        return false;
    }
    // 判断一个字符是不是数字
	public static boolean isNumberize(char c) {
		boolean isNumbered = false; 
		switch(c) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': 
			isNumbered = true;
			break;
		}
		return isNumbered;
	}
}
