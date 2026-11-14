package check_if_array_is_sorted_and_rotated_1878;

class Solution {
    public boolean check(int[] arr) {
        int cnt = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]){
                cnt++;
            }
        }

        if(arr[0] < arr[n-1]) cnt++;
        return cnt<=1;
    }
}