package product_of_two_run_length_encoded_arrays_2019;

import java.util.*;
class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        int num1 = 0;
        int cnt1 = 0;
        int num2 = 0;
        int cnt2 = 0;
        int i=0;
        int j=0;

        while( i < encoded1.length || j < encoded2.length){
            if(cnt1 ==0){
                num1 = encoded1[i][0];
                cnt1 = encoded1[i][1];
                i++;
            }

            if(cnt2 == 0){
                num2 = encoded2[j][0];
                cnt2 = encoded2[j][1];
                j++;
            }

            int min = Math.min(cnt1, cnt2);
            que.offer(new int[]{num1*num2, min});
            cnt1 -= min;
            cnt2 -= min;
        }
        

        int prev = que.peek()[0];
        int total = 0;
        while(!que.isEmpty()){
            if(que.peek()[0] == prev){
                total += que.poll()[1];
            }else{
                result.add(List.of(prev, total));
                prev = que.peek()[0];
                total = que.poll()[1];
            }
        }

        result.add(List.of(prev, total));

        return result;
    }
}