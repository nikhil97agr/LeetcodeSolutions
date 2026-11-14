class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        
        int n = nums.length;

        result.add(nums[n-1]+1);
        int cnt= 0;

        for(int i=n-1;i>=0 && cnt < k;i--){
            if(nums[i] != result.get(cnt)){
                result.add(nums[i]);
                cnt++;
            }
        }

        int ans[] = new int[cnt];

        for(int i=1;i<=cnt;i++){
            ans[i-1] = result.get(i);
        }

        return ans;
    }
}