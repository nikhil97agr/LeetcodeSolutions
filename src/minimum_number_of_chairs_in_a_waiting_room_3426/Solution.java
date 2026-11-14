package minimum_number_of_chairs_in_a_waiting_room_3426;

class Solution {
    public int minimumChairs(String s) {
        int cnt = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == 'E') cnt++;
            else cnt--;

            ans= Math.max(ans, cnt);
        }
        return ans;
    }
}