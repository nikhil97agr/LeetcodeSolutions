package number_of_students_doing_homework_at_a_given_time_1560;

class Solution {
    public int busyStudent(int[] s, int[] e, int t) {
        int ans = 0;

        for(int i=0;i<s.length;i++){
            if(s[i] <= t && t <= e[i]) ans++;
        }

        return ans;
    }
}