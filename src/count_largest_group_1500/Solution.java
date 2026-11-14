package count_largest_group_1500;

class Solution {
    public int countLargestGroup(int n) {
        int cnt[] = new int[50];
        for(int i=1;i<=n;i++){
            int x = i;
            int sum = 0;
            while(x > 0){
                sum += x%10;
                x/=10;
            }
            cnt[sum]++;
        }

        int max = 0;
        for(int x : cnt){
            if(x > max){
                max =x;
            }
        }
        int ans = 0;
        for(int x : cnt){
            if(max == x) ans++;
        }
        return ans;
    }
}