import java.util.Arrays;

class Solution {
    public int minimumK(int[] nums) {
        int ans = 0;
        int min = 1;
        int max= 100000000;
        int c = 0;
        for(int x : nums){
            if(x ==0) c++;
        }
        if(c == nums.length){
            return 0;
        }
        while(min <= max){
            int mid = min + (max - min)/2;
            long cnt = 0;
            for(int x : nums){
                cnt += (1l*x/mid);
                if(x%mid !=0){
                    cnt++;
                }
            }

            
            if(cnt <= 1l * mid * mid){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }

        return ans;
    }
}