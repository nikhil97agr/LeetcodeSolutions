class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Arrays.fill(nge, -1);

        Stack<Integer> stack =new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<= nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }
        int ans = 0;
        for(int i=0;i<n;i++)    
        {
            if(nge[i]!=-1){
                int j= nge[i];
                if(j-i+1>=3) ans++;
            }
        }

        nge = new int[n];
        Arrays.fill(nge, -1);

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        for(int i=0;i<n;i++){
            if(nge[i]!=-1 && nums[nge[i]]!=nums[i] && i - nge[i] +1 >=3) ans++;
        }

        return ans;
    }
}