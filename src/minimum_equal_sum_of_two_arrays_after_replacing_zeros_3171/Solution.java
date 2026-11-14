package minimum_equal_sum_of_two_arrays_after_replacing_zeros_3171;

class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int cnt1 = 0;
        int cnt2 = 0;
        long sum1 = 0;
        long sum2 = 0;

        for(int x : nums1){
            sum1 += x;
            if(x==0) cnt1++;
        }

        for(int x : nums2){
            sum2+=x;
            if(x==0) cnt2++;
        }

        if(cnt1 == 0 && cnt2==0){
            if(sum1 == sum2) return sum1;
            return -1;
        }

        if(cnt1 ==0){
            if(sum1 >= sum2 + cnt2) return sum1;
            return -1;
        }

        if(cnt2 ==0){
            if(sum2 >= sum1 + cnt1) return sum2;
            return -1;
        }

        return Math.max(sum1 + cnt1 , sum2 + cnt2);
    }
}