package longest_mountain_in_array_875;

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = 1;

        for(int i=1;i<n;i++){
            if(arr[i] > arr[i-1]){
                left[i] = left[i-1] + 1;

            }else{
                left[i] = 1;
            }
        }

        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            if(left[i] > 1 && right[i] > 1)
            ans = Math.max(ans, left[i] + right[i] - 1);
        }

        return ans;
    }
}