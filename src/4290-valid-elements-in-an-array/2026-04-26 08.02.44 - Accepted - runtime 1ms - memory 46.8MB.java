class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int n = nums.length;
        for(int i=1;i<n-1;i++){
            boolean a = true;
            boolean b = true;
            for(int j=0;j<i;j++){
                if(nums[i] <= nums[j]){
                     a = false;
                    break;
                }
            }

            for(int j=i +1;j<n;j++){
                if(nums[i] <= nums[j]){
                    b = false;
                    break;
                }
            }
            if(a || b) list.add(nums[i]);
        }
        if(n > 1)
        list.add(nums[n-1]);
        return list;
    }
}