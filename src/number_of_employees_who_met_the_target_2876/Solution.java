package number_of_employees_who_met_the_target_2876;

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for(int x : hours){
            if( x >= target) cnt++;
        }
        return cnt;
    }
}