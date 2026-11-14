package remove_9_660;

class Solution {
    public int newInteger(int n) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int cnt = solve(Integer.toString(mid).toCharArray(), 1, 0, 0, new Integer[11][2][11]);
            int left = mid - cnt;
            if(left < n){
                start = mid + 1;
            }else if(left > n){
                end = mid - 1;
            }else{
                if(notValid(mid)){
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
        }

        return -1;
    }

    private boolean notValid(int n){
        boolean contains = false;
        while(n > 0){
            int dig = n%10;
            if(dig == 9) contains = true;
            n/=10;
        }

        return contains;
    }

    private int solve(char arr[], int flag, int i, int cnt, Integer dp[][][]){
        if(i==arr.length){
            if(cnt ==0) return 0;
            return 1;
        }

        if(dp[i][flag][cnt] !=null) return dp[i][flag][cnt];

        if(flag ==0){
            int ans = 0;
            for(int dig =0;dig<=9;dig++){
                ans += solve(arr, 0, i+1, cnt + (dig == 9 ? 1 : 0), dp);
            }

            return dp[i][flag][cnt] = ans;
        }else{
            int ans = 0;
            int last = arr[i] - '0';
            for(int j=0;j<last;j++){
                ans += solve(arr, 0, i+1, cnt + (j == 9 ? 1 : 0), dp);
            }

            ans += solve(arr, 1, i+1, cnt + (last == 9 ? 1 : 0), dp);
            return dp[i][flag][cnt] = ans;
        }

    }
}