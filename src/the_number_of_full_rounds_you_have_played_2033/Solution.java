package the_number_of_full_rounds_you_have_played_2033;

class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int curr = 0;
        int diff = 15;
        int login = Integer.parseInt(loginTime.split(":")[0]) * 60 + Integer.parseInt(loginTime.split(":")[1]);
        int logout = Integer.parseInt(logoutTime.split(":")[0]) * 60 + Integer.parseInt(logoutTime.split(":")[1]);
        int end = 24 * 60;
        int ans = 0;
        while(curr < login){
            curr += diff;
        }
        while(curr + diff<= ((logout < login) ? end : logout)){
            ans++;
            curr += diff;
        }

        if(logout < login){
            curr = 0;
            while(curr + diff <= logout){
                ans++;
                curr += diff;
            }
        }

        return ans;
    }
}