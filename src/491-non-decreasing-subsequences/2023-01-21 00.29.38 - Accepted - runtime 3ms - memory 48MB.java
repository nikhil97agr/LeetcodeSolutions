class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int n = nums.length;
        solve(0, n, -101, result, temp,nums);
        return result;
    }

    private void solve(int i, int n,int prev, List<List<Integer>> result, List<Integer> temp, int[] nums){
        if(i==n){
            if(temp.size()>=2){
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if(nums[i]>=prev){
            temp.add(nums[i]);
            solve(i+1, n, nums[i], result, temp,nums);
            temp.remove(temp.size()-1);
        }

        if(nums[i]!=prev){
            solve(i+1, n, prev, result, temp, nums);
        }
        ;
    }


}