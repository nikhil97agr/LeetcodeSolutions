package smallest_rotation_with_highest_score_814;

class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;

        int cnt[] = new int[n+1];

        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val > i){
                int start = i + 1;
                int end = start + (n-1 - val);
                cnt[start]++;
                cnt[end+1]--;
            }else{
                int start = 0;
                int end = i - val;
                cnt[start]++;
                cnt[end+1]--;

                start = i+1;

                if(i+1 < n){
                    end = start + (n-i - 2);
                    cnt[start]++;
                    cnt[end+1]--;
                }
            }
        }

        int ans = -1;
        int c = 0;   
        int max = -1;

        for(int i=0;i<=n;i++){
            c+=cnt[i];

            if(c > max){
                max = c;
                ans = i;
            }
        }

        return ans;
    }
}