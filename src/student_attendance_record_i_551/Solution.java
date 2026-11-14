package student_attendance_record_i_551;

class Solution {
    public boolean checkRecord(String s) {
        int l = 0;
        int a = 0;

        for(char c : s.toCharArray()){
            if(c=='A')a++;
            if(c=='L') l++;
            else l=0;
            if(a>=2 || l>=3) return false;
        }

        return true;
    }
}