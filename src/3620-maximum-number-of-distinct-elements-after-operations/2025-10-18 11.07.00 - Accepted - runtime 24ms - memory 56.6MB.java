class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer>list = new ArrayList<>();
        int n = nums.length;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(list.isEmpty()){
                list.add(nums[i] + k);
            }else{
                int req = Math.min(k,list.get(list.size() - 1) - nums[i]-1);
                if(req >= -k){
                    list.add(nums[i] + req);
                }
            }
        }

        return list.size();
    }
}