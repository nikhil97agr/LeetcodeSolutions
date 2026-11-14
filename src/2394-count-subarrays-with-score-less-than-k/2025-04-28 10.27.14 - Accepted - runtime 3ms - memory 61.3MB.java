class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int length = 0;
        long total =((long)n)*((long)(n+1))/((long)2);
        long sum = 0;
        int j = 0;
        for(int i=0;i<n;i++){
            sum += (long)nums[i];
            length++;
            if(sum*length>=k){
                total -=(long) (1+n-1-i);
                while(j<=i&&sum*length>=k){
                    sum -=(long) nums[j];
                    length--;
                    if(sum*length>=k){
                        total -= (long)(n-1-i+1);
                    }
                    
                    j++;
                }
            }
        }
        return total;
    }
}