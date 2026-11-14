package rotate_string_812;

class Solution {
    public boolean rotateString(String s, String goal) {
        int n= goal.length();
        if(s.length() != goal.length()) return false;
        goal += goal;

        for(int i=0;i<n;i++){
            if(s.equals(goal.substring(i, i+n))) return true;
        }

        return false;
    }
}