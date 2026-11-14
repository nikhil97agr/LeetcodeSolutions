package smallest_subarrays_with_maximum_bitwise_or_2498;

import java.util.*;
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        List<Integer> bitIndex[] = new ArrayList[30];

        for(int i=0;i<30;i++) {
            bitIndex[i] = new ArrayList<>();

            for(int x=0;x<n;x++){
                if((nums[x] & (1<<i))!=0){
                    bitIndex[i].add(x);
                }
            }
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int cnt = 1;

            for(int j=0;j<30;j++){
                int start =0;
                int end = bitIndex[j].size()-1;

                int ind = -1;

                while(start <= end){
                    int mid= (start + end)/2;

                    if(bitIndex[j].get(mid) >= i){
                        ind = mid;
                        end = mid-1;
                    }else{
                        start = mid+1;
                    }
                }

                if(ind!= -1){
                    cnt = Math.max(cnt, (bitIndex[j].get(ind) - i + 1));
                }
            }
            ans[i] = cnt;
        }

        return ans;
        

        
    }
}