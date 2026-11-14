class Solution {
    public long distantSubarrays(int[] nums, int goal, int k) {
        List<Long> list = new ArrayList<>();
        long sum = 0;
        long ans = 0;
        list.add(0l);
        for(int x : nums){
            sum += x;

            long d1 = k - goal +sum;
            long d2 = sum - goal - k;

            int c1 = lessThanEqual(list, d2);
            int c2 = list.size() - (k == 0 ? lessThanEqual(list, d1 ) : lessThanEqual(list, d1 - 1));

            ans += (c1 + c2);
            int ind = Collections.binarySearch(list, sum);
            if(ind <  0){
                ind = -ind - 1;
            }

            if(ind ==list.size()) list.add(sum);
            else list.add(ind, sum);
        }

        return ans;
    }



    private int lessThanEqual(List<Long> list, long val){
        int ans = 0;
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) <= val){
                ans = mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }

}


/**

        (ss - x) - g >= k | g - (ss - x) >= k
    =>  ss -x -g >= k | g - ss + x >= k
    => x <= ss - g- k | k - g + ss <= x
    => k - g + ss <= x | x <= ss - g - k
 */