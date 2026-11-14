class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int sl = landStartTime[i];
                int el = sl + landDuration[i];
                int sw = waterStartTime[j];
                int ew = sw + waterDuration[j];

                ans = Math.min(ans,
                              Math.min(
                            Math.max(el, sw) + waterDuration[j],
                            Math.max(ew, sl) + landDuration[i]  
                              ));

                
            }
        }

        return ans;
    }


}