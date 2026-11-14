package number_of_student_replacements_3960;

class Solution {
    public int totalReplacements(int[] ranks) {
        int ans = 0;
        int curr = ranks[0];
        for(int x : ranks){
            if(x < curr){
                ans++;
                curr = x;
            }
        }

        return ans;
    }
}