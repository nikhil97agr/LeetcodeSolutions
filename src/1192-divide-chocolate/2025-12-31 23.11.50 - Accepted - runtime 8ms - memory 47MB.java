class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int start = 0;
        int end = Arrays.stream(sweetness).sum();
        int ans = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            int sum=0;
            int cnt = 0;
            for(int x : sweetness){
                sum += x;
                if(sum >= mid){
                    cnt++;
                    sum = 0;
                }
            }

            if(cnt > k){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}