package solutions;
/*
* 10. 正则表达式匹配
*       https://leetcode.cn/problems/regular-expression-matching/description/
*
*
* */
public class Solution10 {
    public Solution10(){}
    public static boolean isMatch(String s, String p) {
        if(s.charAt(s.length()-1) != p.charAt(p.length() -1) && (p.charAt(p.length() -1) != '.' && p.charAt(p.length() -1) != '*' )){
            return false;
        }
        int pointerS = 0, pointerP = 0;
        while(pointerS <= s.length() - 1) {
            System.out.println();
            if(pointerP > p.length() - 1) {
                return false;
            }
            if(s.charAt(pointerS) != p.charAt(pointerP)) {
                if(p.charAt(pointerP) == '.') {
                    pointerP += 1;
                }else if(p.charAt(pointerP) == '*') {
                    if(pointerP - 1 >= 0) {
                        if(p.charAt(pointerP - 1) == '.') {
                            if(pointerP == p.length() - 1){
                                return true;
                            }
                        }else if(p.charAt(pointerP - 1) != '.' && p.charAt(pointerP - 1) != s.charAt(pointerS)){
                            if(pointerP + 1 < p.length() && (p.charAt(pointerP + 1) == s.charAt(pointerS) ||p.charAt(pointerP + 1) == '.')) {
                                pointerP += 2;
                            }else {
                                return false;
                            }
                        }
                    }else {
                        return false;
                    }
                }else if (pointerP + 1 < p.length() && p.charAt(pointerP + 1) == '*') {
                    pointerP += 2;
                }else{
                    return false;
                }
            }else {
                pointerP += 1;
            }
            // always through this:
            pointerS += 1;
        }
        return true;
    }
}