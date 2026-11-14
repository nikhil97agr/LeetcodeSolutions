package closest_subsequence_sum_1881;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        long ans = Integer.MAX_VALUE;
        int n = nums.length;
        List<Long> l1 = subset(IntStream.range(0, n/2).mapToLong( x -> nums[x]).toArray());
        List<Long> l2 = subset(IntStream.range(n/2, n).mapToLong(x-> nums[x]).toArray());

        Collections.sort(l2);

        for(long x : l1){
            long r1 = find(x- goal,x, goal, l2);
            long r2 = find(goal - x,x, goal, l2);

            ans = Math.min(ans, 
            Math.min(r1, r2));
        }
 


        return (int)ans;
    }

    private long find(long val, long curr, long goal, List<Long> list){
        long a = 0;
        long b = 0;

        int start =0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start +end)/2;

            if(list.get(mid) <= val){
                a = list.get(mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        start =0;
        end = list.size() - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid ) >= val){
                b = list.get(mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        long diff1 = Math.abs(a + curr - goal);
        long diff2 = Math.abs(b + curr - goal);

        return diff1 < diff2 ? diff1 : diff2;

    }

    private List<Long> subset(long nums[]){
        List<Long> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            long sum =0;
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    sum += nums[j];
                }
            }

            result.add(sum);
        }

        return result;
    }
}