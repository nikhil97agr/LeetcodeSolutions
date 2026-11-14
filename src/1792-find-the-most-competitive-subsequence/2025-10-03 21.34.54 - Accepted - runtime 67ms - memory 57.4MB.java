class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int ans[] = new int[k];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i] < stack.peek() && k - stack.size() <= n- i -1){
                stack.pop();
            }

            if(stack.size() < k) stack.push(nums[i]);
        }

        for(int i=k-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}