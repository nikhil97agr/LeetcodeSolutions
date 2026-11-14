package palindromic_substrings_647;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            count += 1+countLength(s, n, i-1, i+1) + countLength(s, n, i, i+1);
        }
        return count;
    }

    private int countLength(String s, int n, int start, int end){
        if(start < 0 || end >= n || s.charAt(start) !=s.charAt(end)) return 0;

        return 1 + countLength(s, n , start-1, end+1);
    }
}