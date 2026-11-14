package find_the_pivot_integer_2571;

class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += i;
        }

        int sum2 = 0;
        for(int i=1;i<=n;i++){
            sum2 += i;
            if(sum2 == sum) return i;
            sum -= i;

        }
        return -1;
    }
}