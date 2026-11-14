class Solution {
    public long countQuadruplets(int[] nums) {
        long ans = 0;
        int n = nums.length;
        List<Integer> pre = new ArrayList<>();
        pre.add(nums[0]);
        for(int j=1;j<n;j++){
            long c2 = nums[n-1] > nums[j] ? 1 : 0;
            for(int k=n-2;k>j;k--){
                if(nums[j] > nums[k]){
                    long c1 = bs1(pre, nums[k]);
                    ans += c1 * c2;

                    
                
                }
                if(nums[k] > nums[j]){
                    c2++;
                }
            }

            int ind = Collections.binarySearch(pre, nums[j]);
            if(ind < 0){
                ind = -ind - 1;
            }
            if(ind == pre.size()){
                pre.add(nums[j]);
            }else{
                pre.add(ind, nums[j]);
            }
        }

        return ans;
    }

    private long bs2(List<Integer> list, int val){
        long ans =0;
        int n = list.size();
        int start =0;
        int end = n-1;
        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) > val){
                ans = n - mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    private long bs1(List<Integer> list, int val){
        int start =0;
        int end = list.size() - 1;
        long ans = 0;
        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) < val){
                ans = mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}