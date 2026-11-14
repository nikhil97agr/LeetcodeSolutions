import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        long ans= 0;
        int n = nums.length;
        int pre[] = new int[n+1];
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + (nums[i-1] == target ? 1 : -1);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i=1;i<=nums.length;i++){
            int val = pre[i];

            int cnt = bs(list, val);

            ans += cnt;
            if(cnt == list.size()) list.add(val);
            else{
                list.add(cnt, val);
            }
            
        }


        return ans;
    }

    int bs(List<Integer> list, int target){

        if(target <= list.get(0)){
            return 0;
        }
        int start = 0;
        int end = list.size()-1;
        int ans = end + 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(list.get(mid) < target){
                ans =mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}