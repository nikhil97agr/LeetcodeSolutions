class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        boolean pre[] = new boolean[n];
        boolean suf[] = new boolean[n];
        int cnt =1;
        pre[1] = k == 1? true: false;
        for(int i=1;i<n-1;i++){
            if(nums[i] <= nums[i-1]){
                cnt++;
            }else{
                cnt = 1;
            }

            if(cnt >= k){
                pre[i+1] = true;
            }
        }

        suf[n-2] = (k==1) ? true : false;

        for(int i=n-2;i>0;i--){
            if(nums[i] <= nums[i+1]){
                cnt++;
            }else{
                cnt = 1;
            }

            if(cnt>=k) suf[i-1] = true;
        }

        for(int i=k;i<n-k;i++){
            if(pre[i] && suf[i]) res.add(i);
        }

        return res;
    }
}