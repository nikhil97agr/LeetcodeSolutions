class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n= arr.length;
        int ans = 1;
        int cnt = 1;
        int prev = 0;

        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]){
                if(prev !=1){
                    cnt++;
                    prev = 1;
                }else{
                    ans= Math.max(ans, cnt);
                    cnt = 2;
                }
            }else if(arr[i] < arr[i+1]){
                if(prev != -1){
                    cnt++;
                    prev = -1;
                }else{
                    ans = Math.max(ans, cnt);
                    cnt = 2;
                }
            }else{
                ans = Math.max(ans, cnt);
                prev = 0;
                cnt = 1;
            }
        }

        return Math.max(ans, cnt);
    }
}