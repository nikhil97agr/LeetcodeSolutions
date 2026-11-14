class Solution {
    public int hIndex(int[] citations) {
        int start = 1;
        int n = citations.length;
        int end = n;
        int ans = 0;

        while(start <= end){
            int mid = (start + end)/2;
            int total = 0;
            for(int val : citations){
                if(val >= mid) total++;
            }

            if(total >= mid){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}