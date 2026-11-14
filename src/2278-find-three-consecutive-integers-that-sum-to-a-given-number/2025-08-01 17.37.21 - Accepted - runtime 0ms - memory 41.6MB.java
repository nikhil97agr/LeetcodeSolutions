class Solution {
    public long[] sumOfThree(long num) {
        if(num%3!=0) return new long[0];

        long val = num/3;
        return new long[]{val-1, val, val+1};
    }
}