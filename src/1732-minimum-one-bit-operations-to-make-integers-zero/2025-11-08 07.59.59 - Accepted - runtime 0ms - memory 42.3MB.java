class Solution {
    public int minimumOneBitOperations(int n) {
        if(n==0) return 0;

        int pow = (int)(Math.log(n)/Math.log(2));
        int num = 1<<pow;

        return (1<<(pow+1))-1 - minimumOneBitOperations((n^num));
    }
}