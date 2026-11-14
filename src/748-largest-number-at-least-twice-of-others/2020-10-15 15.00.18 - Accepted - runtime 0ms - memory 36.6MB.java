class Solution {
    public int dominantIndex(int[] nums) {
     int max = -1;
    int index = -1;
    for(int i = 0;i<nums.length;i++)
    {
        if(nums[i]>max)
        {
            index = i;
            max = nums[i];
        }
    }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=max&&2*nums[i]>max)
                return -1;
        }
        
        return index;
    }
}