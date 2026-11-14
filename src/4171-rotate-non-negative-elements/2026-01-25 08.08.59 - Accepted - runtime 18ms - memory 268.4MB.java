class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] >=0){
                list.add(i);
            }
        }
        int ans[] = nums.clone();
        int len = list.size();
        for(int i=0;i<len;i++){
            int left = k % len;
            int ind = (i - left + len)%len;
            ans[list.get(ind)] = nums[list.get(i)];
        }

        return ans;
    }
}