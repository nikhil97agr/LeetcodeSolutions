class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list =new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int ind = index[i];
            int val = nums[i];

            if(ind == list.size()){
                list.add(val);
            }else{
                list.add(ind, val);
            }
        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++) ans[i]  = list.get(i);


        return ans;
    }
}