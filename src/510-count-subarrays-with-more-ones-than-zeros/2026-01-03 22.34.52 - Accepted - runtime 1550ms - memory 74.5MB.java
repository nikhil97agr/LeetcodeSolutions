class Solution {
    public int subarraysWithMoreOnesThanZeroes(int[] nums) {
        int ans = 0;

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] ==0){
                nums[i] = -1;
            }
        }
        for(int i=0;i<n;i++){
            sum += nums[i];
            if(sum > 0) ans++;
            int req = sum - 1;
            int cnt = bs(list, req);
            ans = add(ans, cnt);
            int ind = Collections.binarySearch(list, sum);
            if(ind < 0){
                ind = -ind - 1;
            }
            if(ind == list.size()) list.add(sum);
            else list.add(ind, sum);
        }
        return ans;
    }

    private int bs(List<Integer> list, int val){
        int ind = -1;

        int start = 0;
        int end = list.size() -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) <= val){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ind + 1;
    }

    private int add(int a, int b){
        long mod = (long)1e9 +7;
        long sum = mod + a + b;

        return (int)(sum%mod);
    }
}