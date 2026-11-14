class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        boolean hasZero = false;
        int one = 0;
        int zero = 0;
        for(char c : binary.toCharArray()){
            if(c=='1'){
                one = add(one, add(zero, 1));
            }else{
                hasZero = true;
                zero = add(zero, one);
            }
        }

        return add(zero, add(one, hasZero ? 1 : 0));
    }

    private int add(long a, long b){
        int mod = 1_000_000_007;
        return (int)((a+b)%mod);
    }
}