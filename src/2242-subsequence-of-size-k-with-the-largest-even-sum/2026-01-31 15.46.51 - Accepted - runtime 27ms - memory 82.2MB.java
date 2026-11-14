class Solution {
    public long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;
        long sum = 0;
        int ind = n;
        while( k >0 ){
            sum += nums[--ind];
            k--;
        }

        if(sum%2==0) return sum;

        long m1 = removeOdd(nums, ind, sum);
        long m2 = removeEven(nums, ind, sum);
        return Math.max(m1, m2);


    }

    private long removeEven(int nums[], int ind, long sum){
        int me = Integer.MAX_VALUE;
        int mo = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<ind;i++){
            if(nums[i]%2==0) continue;
            mo = Math.max(mo, nums[i]);
        }

        for(int i=ind;i<n;i++){
            if(nums[i]%2==1) continue;
            me = Math.min(me, nums[i]);
        }

        if(mo == Integer.MIN_VALUE || me == Integer.MAX_VALUE) return -1;
        return sum - me + mo;
    }

    private long removeOdd(int nums[], int ind, long sum){
        int mo = Integer.MAX_VALUE;
        int me = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<ind;i++){
            if(nums[i]%2==1) continue;
            me = Math.max(me, nums[i]);
        }

        for(int i=ind;i<n;i++){
            if(nums[i]%2==0) continue;
            mo = Math.min(mo, nums[i]);
        }

        if(mo == Integer.MAX_VALUE || me == Integer.MIN_VALUE) return -1;
        return sum - mo + me;
    }
}