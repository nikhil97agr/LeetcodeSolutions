class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long mid = nums[n/2];
        long min = findPalindrome(-1, mid);
        long max = findPalindrome(1, mid);
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<n;i++){
            sum1 += Math.abs(max - nums[i]);
            sum2 += Math.abs(min - nums[i]);
        }
        return Math.min(sum1, sum2);
    }

    public long findPalindrome(int diff, long mid){
        while(true){
            char arr[] = (""+mid).toCharArray();
            if(isPal(arr)){
                return mid;
            }
            mid+= diff;
        }

    }

    public boolean isPal(char arr[]){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            if(arr[start]!= arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}