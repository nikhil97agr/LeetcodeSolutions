package count_odd_numbers_in_an_interval_range_1630;

class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if(low==high && high%2==1){
            return 1;
        }
        if(low%2==1){
            low++;
            count++;
        }
        if(high%2==1){
            high--;
            count++;
        }

        count += (high-low)/2;
        return count;
    }
}