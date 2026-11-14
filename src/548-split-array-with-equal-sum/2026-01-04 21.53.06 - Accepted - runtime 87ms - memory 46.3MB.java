class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        long pre[] = new long[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }

        for(int j=0;j<n;j++){
            Set<Long> set = new HashSet<>();
            for(int i=1;i+1<j;i++){
                long s1 = pre[i-1];
                long s2 = pre[j-1] - pre[i];
                if(s1 == s2){
                    set.add(s1);
                }
            }

            for(int k=j+2;k<n-1;k++){
                long s1 = pre[k-1] - pre[j];
                long s2 = pre[n-1] - pre[k];
                if(s1 == s2 && set.contains(s2)) return true;
            }
        }

        return false;
    }
}