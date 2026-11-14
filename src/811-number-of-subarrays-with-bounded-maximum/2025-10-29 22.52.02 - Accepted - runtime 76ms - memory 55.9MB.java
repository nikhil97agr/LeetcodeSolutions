class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int lnge[] = lnge(nums);
        int rnge[] = rnge(nums);
        int ans = 0;
        for(int i=0;i<n;i++){
            if(nums[i] >= left && nums[i] <= right){
                int rcnt = lnge[i];
                int lcnt = rnge[i];

                if(rcnt == -1) rcnt = n - i ;
                else{
                    if(nums[rcnt] == nums[i]){
                        rcnt = rcnt - i + 1;
                    }else{
                        rcnt = rcnt - i;
                    }
                }

                if(lcnt == -1) lcnt = i + 1;
                else{
                    lcnt = i - lcnt;
                }
                ans += lcnt * rcnt;
            }
        }

        return ans;
    }


    private int[] lnge(int nums[]){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nge;
    }

        private int[] rnge(int nums[]){
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                nge[stack.pop()] = i;
            }

            stack.push(i);
        }

        return nge;
    }


}