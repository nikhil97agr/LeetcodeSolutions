class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int n = nums.length;
        int lookUp[][] = new int[n][31];
        for(int i=0;i<n;i++)
        {
            int j = 30;
            int x = nums[i];
            while(x>0&&j>=0)
            {
                lookUp[i][j] = x%2;
                x>>=1;
                j--;
            }
        }
        int total = 0;
        for(int i=0;i<31;i++)
        {
            int zeroCount = 0;
            int oneCount = 0;
            for(int j=0;j<n;j++)
            {
                if(lookUp[j][i]==1)
                    oneCount++;
                else
                    zeroCount++;
            }
            total+=(oneCount*zeroCount);
        }
        return total;
    }
}