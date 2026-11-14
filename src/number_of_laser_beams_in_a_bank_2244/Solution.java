package number_of_laser_beams_in_a_bank_2244;

class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int currCount = 0;
        int prevCount = 0;
        for(String s : bank){
            currCount = 0;
            for(char c : s.toCharArray()){
                if(c=='1') currCount++;
            }
            if(currCount!=0){
                ans += prevCount*currCount;
                prevCount = currCount;
            }
        }
        return ans;
    }
}