class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int one = 0;
        for(int x :data){
            if(x == 1) one++;
        }
        if(one ==0) return 0;
        int ans = n;
        int cnt = 0;
        int start =0;
        int end = 0;
        while(end < one-1){
            if(data[end] ==0){
                cnt++;
            }
            end++;
        }
        while(end < n){
            if(data[end] == 0){
                cnt++;
            }
            end++;
            ans= Math.min(ans, cnt);

            if(data[start] ==0){
                cnt--;
            }
            start++;
        }

        return ans;
    }
}