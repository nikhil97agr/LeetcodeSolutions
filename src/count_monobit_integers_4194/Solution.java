package count_monobit_integers_4194;

class Solution {
    public int countMonobit(int n) {
        int ans = 1;
        for(int i=1;i<=n;i++){
            int next = i + 1;
            if((next & (next-1)) ==0){
                ans++;
            }
        }

        return ans;
    }
}