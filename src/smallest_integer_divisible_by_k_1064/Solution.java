package smallest_integer_divisible_by_k_1064;

class Solution {
    public int smallestRepunitDivByK(int k) {
        int len = 0;
        int dig = 0;
        if(k%2==0) return -1;
        while( len <= 50000){
            dig = dig*10 + 1;
            dig = dig%k;
            len++;
            if(dig == 0){
                return len;
            }
        }

        return -1;
    }

    
}