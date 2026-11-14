class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int n = digits.length;
        for(int j=n-1;j>=0;j--){
            digits[j] += carry;
            carry = digits[j]/10;
            digits[j]%=10;
        }

        if(carry == 1){
            int ans[] = new int[n+1];
            ans[0] = 1;
            for(int i=1;i<=n;i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }else{
            return digits;
        }
    }
}