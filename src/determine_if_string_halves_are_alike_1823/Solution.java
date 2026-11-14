package determine_if_string_halves_are_alike_1823;

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int cnt1 = count(s.substring(0, n/2));
        int cnt2 = count(s.substring(n/2, n));

        return cnt1 == cnt2;
    }

    private int count(String s){
        int count = 0;
        String vowels = "AEIOUaeiou";

        for(char c : s.toCharArray()){
            if(vowels.indexOf(c)!=-1) count++;
        }
        return count;
    }
}