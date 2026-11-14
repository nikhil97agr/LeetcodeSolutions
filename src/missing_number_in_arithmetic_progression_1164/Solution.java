package missing_number_in_arithmetic_progression_1164;

class Solution {
    public int missingNumber(int[] arr) {
        int min = Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[2] - arr[1]));
        if(arr[1] < arr[0]){
            min = -min;
        }
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            if(arr[i+1] - arr[i] != min){
                return arr[i] + min;
            }
        }
        return arr[0];
    }
}