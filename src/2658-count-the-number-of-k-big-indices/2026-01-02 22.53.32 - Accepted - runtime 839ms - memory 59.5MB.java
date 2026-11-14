class Solution {
    public int kBigIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        boolean ans[] = new boolean[n];

        for(int i=0;i<n;i++){
            int cnt = bs(list, nums[i]);
            if(cnt >= k){
                ans[i] = true;
            }

            int ind = Collections.binarySearch(list, nums[i]);
            if(ind < 0){
                ind = -ind - 1;
            }

            if(ind == list.size()){
                list.add(nums[i]);
            }else{
                list.add(ind, nums[i]);
            }
        }

        list.clear();
        for(int i= n-1;i>=0;i--){
            int cnt= bs(list, nums[i]);
            if(cnt >=k){
                ans[i] &= true;
            }else{
                ans[i] = false;
            }

            int ind = Collections.binarySearch(list, nums[i]);
            if(ind <0){
                ind = -ind - 1;
            }

            if(ind == list.size()){
                list.add(nums[i]);
            }else{
                list.add(ind, nums[i]);
            }
        }

        int total =0;

        for(boolean x : ans){
            if(x) total++;
        }

        return total;
    }

    private int bs(List<Integer> list, int val){
        int start = 0;
        int end = list.size() - 1;
        int cnt = 0;

        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) < val){
                cnt = mid + 1;
                start = mid + 1;
            }else{
                end = mid- 1;
            }
        }

        return cnt;
    }
}