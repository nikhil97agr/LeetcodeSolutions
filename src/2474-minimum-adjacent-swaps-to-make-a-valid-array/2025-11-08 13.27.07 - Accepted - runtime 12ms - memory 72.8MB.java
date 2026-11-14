import java.util.Arrays;

class Solution {
    public int minimumSwaps(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int ans = 0;
        int n=  nums.length;
        int ind = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == min){
                ind = i;
                break;
            }
        }
        for(int i = ind; i > 0;i--){
            int temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
            ans++;
        }
        
        ind = -1;
        for(int i=n-1;i>=0;i--){
            if(nums[i] == max){
                ind = i;
                break;
            }
        }
        
        for(int i= ind;i<n-1;i++){
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
            ans++;
            
        }
        return ans;
    }
}