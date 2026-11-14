package number_of_sub_arrays_of_size_k_and_average_greater_than_or_equal_to_threshold_1445;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        
        int n = arr.length;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        int start = 0;
        int end = k;

        int ans = check(sum,k, threshold) ? 1 : 0;

        while(end < n){
            sum -= arr[start];
            sum += arr[end];
            if(check(sum, k, threshold)) ans++;
            end++;
            start++;
        }

        return ans;

        
    }

    private boolean check(int sum, int k, int t){
        double avg = (1d*sum)/k;

        return avg >= 1d*t;
    }
}