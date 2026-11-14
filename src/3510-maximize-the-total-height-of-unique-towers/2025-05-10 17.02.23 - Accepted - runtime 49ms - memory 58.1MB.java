class Solution {
    public long maximumTotalSum(int[] arr) {
        long ans = 0;
        Arrays.sort(arr);

        int n = arr.length;
        int prev = arr[n-1] + 1;

        for(int i=n-1;i>=0;i--){
            int x = arr[i];

            if(prev <=x){
                prev--;
                if(prev<=0) return -1;
                ans += prev;
            }else{
                ans += x;
                prev = x;
            }
            
        }
        return ans;
    }
}