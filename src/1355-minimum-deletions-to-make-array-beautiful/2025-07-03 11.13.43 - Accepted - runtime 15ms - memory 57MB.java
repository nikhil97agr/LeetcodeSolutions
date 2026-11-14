class Solution {
    public int minDeletion(int[] nums) {
        int ans= 0;

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;){
            list.add(nums[i]);
            i++;
            while(i < nums.length && nums[i] == list.get(list.size() - 1)){
                ans++;
                i++;
            }
            if(i < nums.length){
                list.add(nums[i]);
            }
            i++;
        }

        if(list.size()%2==1) return ans+1;
        return ans;
    }
}