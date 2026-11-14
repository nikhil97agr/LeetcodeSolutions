class Solution {
    
    class Pair{
        int first;
        int second;
        Pair()
        {
            first = 0;
            second = 0;
        }
    }
    public int findShortestSubArray(int[] nums) {
        int count[] = new int[50000];
        Pair[] pair = new Pair[50000];
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
            if(pair[nums[i]]==null)
            {
                pair[nums[i]] = new Pair();
                pair[nums[i]].first = i;
                pair[nums[i]].second = i;
            }
            else
            {
                pair[nums[i]].second = i; 
            }
        }
        int ans = Integer.MAX_VALUE;
        int degree = Integer.MIN_VALUE;
        for(int  x : count)
            degree = Math.max(degree, x);
        
        for(int x : nums)
        {
            if(count[x] == degree)
            {
                ans = Math.min(ans, pair[x].second - pair[x].first + 1);
            }
        }
        return ans;
    }
}