class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int ind = 0;
        while(num>0){
            int mod = num%2;
            if(mod ==0){
                ans = ans | (1<<ind);
            }
            ind++;
            num/=2;
        }
        return ans;
    }
}