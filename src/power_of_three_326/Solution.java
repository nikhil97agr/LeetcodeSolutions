package power_of_three_326;

class Solution {
    public boolean isPowerOfThree(int n) {

        if(n <= 0) return false;
        int temp = (int)(Math.log(n)/Math.log(3));

        return Math.pow(3, temp)== n || Math.pow(3, temp+1)==n;
    }
}