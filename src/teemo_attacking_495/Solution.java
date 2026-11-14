package teemo_attacking_495;

class Solution {
    public int findPoisonedDuration(int[] arr, int d) {
        int ans = 0;
        int nextStart = 0;
        int prevStart = 0;
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i] >= nextStart){
                ans += (nextStart - prevStart);
                prevStart = arr[i];
                nextStart = arr[i] + d;
            }else{
                ans += (arr[i] - prevStart);
                prevStart = arr[i];
                nextStart = arr[i] + d;
            }
        }

        ans += nextStart - prevStart;

        return ans;
    }
}