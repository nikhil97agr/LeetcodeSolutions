class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<List<Integer>, Integer> map = new HashMap();
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            int sumLeft = -nums[i];
            int left = i+1;
            int right = n-1;
            while(left < right){
                int total = nums[left] + nums[right];
                if(total==sumLeft){
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    map.put(temp, 1);
                    left ++;
                }
                else if(total > sumLeft){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return new ArrayList(map.keySet());
    }
}