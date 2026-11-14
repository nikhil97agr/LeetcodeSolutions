package minimum_number_of_operations_to_make_elements_in_array_distinct_3656;

class Solution {
    public int minimumOperations(int[] nums) {
        int cnt[] = new int[101];
        int ans = 0;
        for(int x : nums){
            cnt[x]++;
        }
        int n = nums.length;
        int i=0;
        for(;i+2 < n ;i+=3){
            boolean res = true;
            for(int x : cnt){
                if(x>1) res = false;
            }

            if(res) return ans;
            ans++;
            cnt[nums[i]]--;
            cnt[nums[i+1]]--;
            cnt[nums[i+2]]--;
        }

        if(i>=n-1) return ans;

        if(i==n-2 && nums[i] == nums[i+1]) ans++;

        return ans;

    }
}