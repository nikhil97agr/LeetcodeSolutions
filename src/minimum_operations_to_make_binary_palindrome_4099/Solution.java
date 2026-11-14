package minimum_operations_to_make_binary_palindrome_4099;

class Solution {
    public int[] minOperations(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            if(isPal(nums[i])){
                ans[i] = 0;
                continue;
            }
            int cnt = Math.min(get(nums[i], 1), get(nums[i], -1));
            ans[i] = cnt;
        }

        return ans;
    }

    private int get(int num, int diff){
        int total = 0;
        while(true){
            total++;
            num += diff;
            if(isPal(num)) return total;
            
        }
    }

    private boolean isPal(int num){
        char bin[] = Integer.toBinaryString(num).toCharArray();
        int start =0;
        int end = bin.length - 1;
        while(start < end){
            if(bin[start] != bin[end]) return false;
            start++;
            end--;
        }

        return true;
    }
}