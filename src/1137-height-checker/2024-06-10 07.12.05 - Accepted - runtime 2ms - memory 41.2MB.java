class Solution {
    public int heightChecker(int[] heights) {
        int temp[] = heights.clone();
        Arrays.sort(temp);
        int cnt = 0;
        for(int i=0;i<heights.length;i++){

            if(temp[i] != heights[i]) cnt++;
        }  
        return cnt;
    }
}