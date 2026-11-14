class Solution {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;

        int ans[] = new int[n];

        int left[] = ngeL(nums);
        int right[] = ngeR(nums);

        for(int i=0;i<n;i++){
            ans[i] = right[i] - left[i] - 1;
        }


        return ans;
    }

    private int[] ngeL(int nums[]){
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();   
        Arrays.fill(nge, -1);

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nge;
    }

    private int[] ngeR(int nums[]){
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(nge, n);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nge;
    }
}