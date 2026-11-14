import java.util.Arrays;

class Solution {
    public int getMaxLen(int[] nums) {
        int cnt = 0;
        boolean zero = false;

        int n = nums.length;
        for(int x : nums){
            if(x ==0 ) zero = true;
            if(x < 0) cnt++;
        }
        if(zero){
            return solve(nums);
        }
        if(cnt%2==0){
            return n;
        }

        int left = -1;
        int right = -1;

        for(int i=0;i<n;i++){
            if(nums[i] < 0){
                if(left == -1) left = i;
                right = i;
            }
        }

        return Math.max(
                left,
                Math.max(n-1-right,
                        Math.max(
                                right, n-1-left)
                )
        );
    }

    private int solve(int arr[]){
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;){
            while(i < n && arr[i] ==0){
                i++;
            }
            if(i  < n ){
                int left = -1;
                int right = -1;
                int start = i;
                int cnt = 0;
                while(start < n && arr[start]!=0){
                    if(arr[start] <0){
                        cnt++;
                        if(left == -1){
                            left = start;
                        }
                        right = start;
                    }
                    start++;
                }

                if(cnt%2 == 0){
                    ans = Math.max(ans, start - i);
                }else{
                    ans = max(ans, left - i, start - 1 - right, start - 1 - left, right -i );
                }
                i = start;


            }
        }
        return ans;
    }

    private int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}