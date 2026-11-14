package total_distance_traveled_2857;

class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        int used = 0;
        while(mainTank > 0){
            mainTank--;
            used++;
            ans += 10;

            if(used==5 && additionalTank !=0){
                mainTank++;
                used = 0;
                additionalTank--;
            }

        }

        return ans;
    }
}