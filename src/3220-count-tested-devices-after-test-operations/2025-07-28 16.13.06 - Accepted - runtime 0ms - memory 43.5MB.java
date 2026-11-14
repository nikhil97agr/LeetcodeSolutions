class Solution {
    public int countTestedDevices(int[] arr) {
        int ans = 0;
        int cnt = 0;
        for(int x : arr){
            if(x -cnt > 0){
                ans++;
                cnt++;
            }
        }
        return ans;
    }


}