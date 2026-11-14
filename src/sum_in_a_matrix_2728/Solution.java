package sum_in_a_matrix_2728;

import java.util.*;
class Solution {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        PriorityQueue<Integer> que[] = new PriorityQueue[n];
        for(int i=0;i<n;i++){
            que[i] = new PriorityQueue<>((a,b)->b-a);
                for(int x : nums[i]){
                    que[i].add(x);
                }
        }
        int score = 0;
        for(int i=0;i<nums[0].length;i++){
            int max = 0;
            for(int j=0;j<que.length;j++){
                max = Math.max(que[j].poll(), max);
            }
            score+= max;
        }
        return score;
    }
}