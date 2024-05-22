package solutions;
/*
* 2129.  将标题首字母大写
*       https://leetcode.cn/problems/capitalize-the-title/description/
* 思路1 capitaizeTile：字符串特征明显，每个单词仅用单个空格连接，且头尾均不含空格。
*       笨办法，将字符串按空格分割转换为字符串数组，数组每个值即为单个单词，将其全部转换为小写后，根据其长度，调整单词首字符大小写，再拼接成原始串。
* 结果：
* 	    内存：后10.43%，
*       执行用时：后15.34%;
*
* 思路2 capitaizeTile2：构造正则表达式匹配，再单独处理第一个单词。
* 结果：
*       内存：41.43MB,击败57.86% java用户；
*       执行用时：4ms，击败24.04% java用户；
* */
import java.util.regex.*;
public class Solution2129 {
	private Solution2129() {}
	/*

	 */
	public static String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        for (int i = 0;i < arr.length; i ++) {
            String temp = arr[i].toLowerCase();
            if(temp.length() > 2) {
                temp = temp.replaceFirst(String.valueOf(temp.charAt(0)),String.valueOf(Character.toUpperCase(temp.charAt(0))));
            }
            arr[i] = temp;
        }
        return String.join(" ",arr);
    }

	public static String capitalizeTitle2(String title) {
        String arr = title.toLowerCase();
        char[] arrArr = arr.toCharArray();
        Pattern pattern1 = Pattern.compile("\\s\\w{3,}");
        Matcher match1 = pattern1.matcher(arr);
        while(match1.find()) {
        	arrArr[match1.start() + 1] = Character.toUpperCase(arr.charAt(match1.start() + 1));
        }
        if (arr.length() >= 3 && arr.charAt(1) != ' ' && arr.charAt(2) != ' ') {
        	arrArr[0] = Character.toUpperCase(arrArr[0]);
        }
        return String.valueOf(arrArr);
    }
}
