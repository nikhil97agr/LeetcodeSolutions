class Solution {
    public int maximumTripletValue(int[] nums) {
        int n = nums.length;
        int suf[] = new int[n];

        suf[n-2] = nums[n-1];
        
        for(int i=n-3;i>=0;i--){
            suf[i] = Math.max(suf[i+1], nums[i+1]);
        }


        TreeSet<Integer> set = new TreeSet<>();
        set.add(nums[0]);
        int ans = 0;
        for(int i=1;i<n-1;i++){
            Integer small = set.lower(nums[i]);

            if(small != null && suf[i] > nums[i]){
                ans = Math.max(ans, small + suf[i] - nums[i]);
            }

            set.add(nums[i]);
        }

        return ans;
    }
}