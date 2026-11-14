class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int dp[] = new int[n];
        int result[] = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            int ind = search(dp, 0, max-1, obstacles[i]);
            dp[ind] = obstacles[i];
            if(ind==max){
              max++;
            }

            result[i] = ind+1;

        }
        return result;
    }

    private int search(int dp[], int start, int end, int target){
        while(start<=end){
          int mid = start + (end-start)/2;
            if(dp[mid]<=target){
                start = mid+1;
            }else{
              end = mid-1;
            }
        }

        return start;
    }
}