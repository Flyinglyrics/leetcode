package solutions;
/*
* 6. Z 字形变换
*   https://leetcode.cn/problems/zigzag-conversion/description/
* 	结果：
*  		执行用时：8ms,击败46.49% java用户
*  		消耗内存：44.37mb,击败39.88%java用户
* */
import java.util.Map;
import java.util.HashMap;

public class Solution6 {
	/**
	 * 

	 */
	public static String convert(String s, int numRows) {
		Map<Integer,StringBuilder> map = new HashMap<>();
		if(numRows < 2) {
			return s;
		}else {
			StringBuilder sb = new StringBuilder();
			for (int i = 1;i <= numRows ;i ++) {
	        	map.put(i, new StringBuilder());
	        }
	        for (int j = 0;j < s.length();j ++) {
	        	int countRow = j % (numRows - 2 + numRows) + 1;
	        	int indx;
	        	if(countRow > numRows) {
	        		indx = numRows - (countRow - numRows);
	        	}else {
	        		indx = countRow;
	        	}
	        	map.get(indx).append(s.charAt(j));
	        }
	        for (int i = 1;i <= numRows ;i ++) {
	        	sb.append(map.get(i).toString());
	        }
	        return sb.toString();
		}
    }
}