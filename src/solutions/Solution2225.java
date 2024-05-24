package solutions;

import java.util.*;

/*
* 2225. 找出输掉零场或一场比赛的玩家
*       https://leetcode.cn/problems/find-players-with-zero-or-one-losses/
* 结果：
*       执行用时：356ms,击败5.03% java用户
*       消耗内存：108.20MB,击败9.88% java用户
**/
public class Solution2225 {
    public Solution2225(){}
    public static List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> win_all = new TreeSet<>();
        Set<Integer> lose_one = new TreeSet<>();
        Set<Integer> loser = new HashSet<>();
        for(int[] match : matches) {
            if(lose_one.contains(match[1])) {
                lose_one.remove(match[1]);
            }else if(!loser.contains(match[1])) {
                lose_one.add(match[1]);
            }
            loser.add(match[1]);
            if(!win_all.contains(match[0]) && !loser.contains(match[0])) {
                win_all.add(match[0]);
            }
            if(win_all.contains(match[1])) {
                win_all.remove(match[1]);
            }
        }
        List<Integer> a = Arrays.asList(win_all.toArray(new Integer[0]));
        List<Integer> b = Arrays.asList(lose_one.toArray(new Integer[0]));
        List<List<Integer>> result = List.of(a,b);
        return result;
    }
}
