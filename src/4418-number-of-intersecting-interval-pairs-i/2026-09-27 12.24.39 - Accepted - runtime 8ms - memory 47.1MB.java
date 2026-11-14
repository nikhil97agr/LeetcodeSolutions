class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int ans = 0;
        int n=  intervals.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(intervals[i], intervals[j])){
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean check(int i1[], int i2[]){
        if(i1[0] >= i2[0] && i1[0] <= i2[1]) return true;
        if(i1[1] >= i2[0] && i1[1] <= i2[1]) return true;

        if(i2[0] >= i1[0] && i2[0] <= i1[1]) return true;
        if(i2[1] >= i1[0] && i2[1] <= i1[1]) return true;
        return false;
        
    }
}