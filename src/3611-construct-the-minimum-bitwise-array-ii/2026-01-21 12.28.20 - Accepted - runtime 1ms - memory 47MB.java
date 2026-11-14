class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int a = nums.get(i);
            if(a%2==0){
                ans[i] = -1;
                continue;
            }
            if((a & (a+1)) ==0)
            {
                ans[i] = (a >> 1);
                continue;
            }

            int pos = -1;
            for(int j=0;j<31;j++){
                if( (a & (1<<j)) !=0 && (a & (1<<(j+1)))==0){
                    pos = j;
                    break;
                }

            }
            ans[i] = a ^(1<<pos);
        }

        return ans;
    }
}