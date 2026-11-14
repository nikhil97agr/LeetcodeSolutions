import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int nge[] = nge(nums, n);
        int ans[] = new int[n];
        int j=n-1;
        Stack<Integer> stack = new Stack<>();
        int ng[][] = new int[n][2];
        for(int i=0;i<n;i++){
            ng[i] = new int[]{nge[i], i};
        }
        int i = n-1;
        Arrays.sort(ng, (a,b) -> a[0] - b[0]);
        Arrays.fill(ans, -1);
        while(i >=0){
            if(ng[i][0] == -1){
                i--;
                continue;
            }
            
            while(j > ng[i][0]){
                while(!stack.isEmpty() && stack.peek() <= nums[j]){
                    stack.pop();
                }
                stack.push(nums[j]);
                j--;
            }
            while(!stack.isEmpty() && stack.peek() <= nums[ng[i][1]]){
                stack.pop();
            }
            ans[ng[i][1]] = (stack.isEmpty() ? -1 : stack.peek());
            i--;
        }
        return ans;
    }

    private int[] nge(int nums[], int n){
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        return nge;
    }
}