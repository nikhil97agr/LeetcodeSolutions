package minimum_time_difference_539;

import java.util.*;
class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<int[]> list = new ArrayList<>();

        for(String s : timePoints){
            String str[] = s.split(":");
            list.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }

        Collections.sort(list, (a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];

            return a[0] - b[0];
        });
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<list.size()-1;i++){
            ans = Math.min(ans, getDifference(list.get(i), list.get(i+1)));
        }

        int second[] = list.get(0);
        int first[] = list.get(list.size()-1);
        
        if(second[1] >= first[1]){
            ans = Math.min(ans, (23 - first[0] + second[0] + 1)*60 + second[1] - first[1]);
        }else{
            ans = Math.min(ans, (60 - (first[1] - second[1]) + (23 - first[0] + second[0])*60));
        }

        return ans;

    }

    private int getDifference(int first[], int second[]){
            if(first[0] == second[0]) return second[1] - first[1];
            if(second[1] >= first[1]){
                int ans = (second[0] -first[0])*60 + (second[1] - first[1]);
                return ans;
            }

            return (second[0] - first[0] - 1)*60 + 60 - (first[1] - second[1]);
    }
}