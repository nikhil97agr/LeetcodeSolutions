class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<Integer> result= new ArrayList<>();
        int min = nums[0];
        int i=0;
        while(i < n){
            if(nums[i] == min){
                i++;
            }else{
                result.add(min);
            }
            min++;
        }

        return result;
    }
}