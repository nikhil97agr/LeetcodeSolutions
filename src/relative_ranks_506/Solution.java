package relative_ranks_506;

import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<String> rank = new ArrayList<>();
        rank.add("Gold Medal");
        rank.add("Silver Medal");
        rank.add("Bronze Medal");
        for(int i=0;i<score.length-3;i++){
            rank.add(""+(i+4));
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        for(int i=0;i<score.length;i++){
            que.offer(new int[]{score[i], i});
        }
        String res[] = new String[score.length];

        for(int i=0;i<score.length;i++){
            res[que.poll()[1]] = rank.get(i);
        }
        return res;
    }
}