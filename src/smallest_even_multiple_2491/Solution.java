package smallest_even_multiple_2491;

class Solution {
    public int smallestEvenMultiple(int n) {
        if(n%2==0){
            return n;
        }
        return n*2;
    }
}