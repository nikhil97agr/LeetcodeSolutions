class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> list = new ArrayList<>();
        int ans = 0;
        list.add(0l);
        long sum =0;
        for(int x : nums){
            sum += x;


            ans += (binarySearch(sum -upper, list) - binarySearch(sum - (lower -1), list));

                        int ind = Collections.binarySearch(list, sum);

            if(ind < 0){
                ind = -ind - 1;
            }

            if(ind == list.size()) list.add(sum);
            else list.add(ind, sum);
        }
        return ans;
    }

    private int binarySearch(long val, List<Long> list){
        int cnt = 0;
        int start =0;
        int end = list.size() - 1;
        int n = list.size();
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) < val){
                start = mid + 1;
            }else{
                cnt = (n- mid);
                end= mid - 1;
            }
        }

        return cnt;
    }
}

// y - x <= lower

// y - lower <= x
