package valid_mountain_array_978;

class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if(n<3)
            return false;
        boolean ans = true;
        int i = 0;
        while(i<n-1)
        {
            if(A[i]>=A[i+1])
                break;
            i++;
        }
        if(i<=0||i==n-1)
            return false;
        while(i<n-1)
        {
            if(A[i]<=A[i+1])
            {
                ans = false;
                break;
            }
            i++;
        }
        return ans;
    }
}