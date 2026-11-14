class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i=0;i<nums.size();i++){
            int ind = i;
            int cnt = 0;
            while(ind!=0)
            {   
                cnt += (ind%2==0) ? 0 : 1;
                ind/=2;
            }
            if(cnt==k) sum += nums.get(i);
        }
        return sum;
    }
}