package closest_divisors_1276;

import java.util.*;
class Solution {
    public int[] closestDivisors(int num) {
        List<int[]> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(num+1);i++){
            if((num+1)%i ==0){
                list.add(new int[]{i, (num+1)/i});
            }
        }

        for(int i=1;i<=Math.sqrt(num+2);i++){
            if((num+2)%i ==0){
                list.add(new int[]{i, (num+2)/i});
            }
        }
        int ans[] = {0, 0};
        int diff = Integer.MAX_VALUE;

        for(int []x : list){
            if(x[1] - x[0] < diff){
                ans = x;
                diff = x[1] - x[0];
            }
        }
        return ans;

        
    }
}