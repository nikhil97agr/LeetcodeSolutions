package statistics_from_a_large_sample_1183;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] sampleStats(int[] count) {
        double sum = 0;
        int total = 0;
        double min = 257;
        double max = 0;
        List<Integer> list = new ArrayList<>();
        double maxCnt=0;
        int cnt= 0;
        for(int i=0;i<256;i++){
            if(count[i] > 0){
                total += count[i];
                sum += 1d*i*count[i];
                min = Math.min(min, i);
                max = Math.max(max, i);
                if(count[i] > cnt){
                    cnt = count[i];
                    maxCnt = i;
                }

                list.add(i);
            }
        }


        int req = (total+1)/2;



        double ans[] = new double[5];
        ans[0] = min;
        ans[1] =max;
        ans[2] = sum/total;
        ans[4] = maxCnt;

        if(total%2==1){
           for(int x : list){
               if(count[x] >= req){
                   ans[3] = x;
                   break;
               }else{
                   req -= count[x];
               }
           }
        }else{
            for(int i=0;i<list.size();i++){
                int c = list.get(i);

                if(count[c] > req){
                    ans[3] = c;
                    break;
                }else if(count[c] == req){
                    ans[3] = (1d*(list.get(i) + list.get(i+1)))/2;
                    break;
                            
                }else{
                    req -= count[c];
                }
            }
        }

        return ans;
    }
}