package find_good_days_to_rob_the_bank_2205;

import java.util.*;
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int left[] = new int[n];
        int right[] = new int[n];
        List<Integer> list = new ArrayList<>();

        left[0] = 1;
        right[n-1] = 1;
        for(int i=1;i<n;i++){
            if(security[i] >= security[i-1]) left[i] = left[i-1] + 1;
            else left[i] = 1;
        }

        for(int i=n-2;i>=0;i--){
            if(security[i] >= security[i+1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
        }

        for(int i=0;i<n;i++){
            if(i-time < 0 || i + time >= n){
                continue;
            }

            if(right[i-time] >= time+1 && left[i+time] >= time+1) list.add(i);
        }

        return list;
    }
}