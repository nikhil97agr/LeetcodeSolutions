package sum_of_absolute_differences_in_a_sorted_array_1787;

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        int sufix[] = new int[n];
        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        sufix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            sufix[i] = sufix[i+1] + nums[i];
        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = (i+1)*nums[i] - prefix[i] + sufix[i] - (n-i)*nums[i]; 
        }

        return ans;
    }
}