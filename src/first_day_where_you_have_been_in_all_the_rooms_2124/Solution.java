package first_day_where_you_have_been_in_all_the_rooms_2124;

class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int days[] = new int[n];
        for(int i=1;i<n;i++){
            if(nextVisit[i-1] == i-1){
                /**
                 * If we are visiting i-1 to i-1 so basically it'll take 2 steps
                 * 1 to go from i-1 to i-1
                 * 2 to go from i-1 to i
                 */
                days[i] = add(days[i-1], 2);
            }else{
                /**
                 * It'll take three parts
                 * 1. 1 step to go from i-1 to nextVisit[i-1]
                 * 2. to go from nextVisit[i-1] to i-1 will take days[i-1] - days[nextVisit[i-1]]
                 * 3. 1 step to go from i-1 to i
                 */
                days[i] = days[i-1];
                days[i] = add(days[i], 1);
                days[i] = add(days[i], add(days[i-1], -days[nextVisit[i-1]]));
                days[i] = add(days[i], 1);
            }
        }

        return days[n-1];
    }

    int add(long a, long b){
        int mod = 1_000_000_007;

        return (int)((a + b + mod)%mod);
    }
}