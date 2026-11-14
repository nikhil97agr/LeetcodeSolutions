class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long sum = 0;
        long ans = 0;
        int n= nums1.length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++){
            set.add(nums1[i]);
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        ans = sum;

        for(int i=0;i<n;i++){
            int x = nums1[i];
            int y = nums2[i];
            Integer higher = set.ceiling(y);
            Integer lower = set.floor(y);
            long curr = Math.abs(x-y);
            if(higher !=null){
                long total = sum;
                total -=curr;
                total += Math.abs(y-higher);
                ans = Math.min(ans, total);
            }

            if(lower !=null){
                long total = sum;
                 total -=curr;
                 total += Math.abs(y-lower);
                 ans = Math.min(ans, total);
            }
        }

        return (int)(ans%mod);
    }

    long mod = (long)1e9 + 7;
}