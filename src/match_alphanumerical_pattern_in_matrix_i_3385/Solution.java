package match_alphanumerical_pattern_in_matrix_i_3385;

import java.util.*;
class Solution {
    public int[] findPattern(int[][] board, String[] pattern) {
        StringBuilder pat = new StringBuilder();
        for(String s : pattern){
            for(char c : s.toCharArray()){
                pat.append(c+":");
            }
        }
        int m = pattern.length;
        int n =pattern[0].length();
        pat.deleteCharAt(pat.length() - 1);
        String s1 = pat.toString();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                String s = build(board, i, j, m, n);
                if(s.isEmpty()) continue;

                if(match(s, s1)) return new int[]{i, j};
            }
        }

        return new int[]{-1,-1};
    }

    private boolean match(String s, String pat){
        char assigned[] = new char[26];
        char val[] = new char[26];
        Arrays.fill(val, ' ');
        Arrays.fill(assigned, ' ');
        for(int i=0;i<s.length();i+=2){
            if(Character.isDigit(pat.charAt(i))){
                if(s.charAt(i) != pat.charAt(i)) return false;
            }else{
                char c1 = pat.charAt(i);
                char c2 = s.charAt(i);
                if(val[c2-'0'] == ' ' && assigned[c1-'a'] == ' '){
                    val[c2-'0'] = c1;
                    assigned[c1-'a'] = c2;
                }else if(val[c2-'0'] == ' ' || assigned[c1-'a'] == ' '){
                    return false;
                }else if(val[c2-'0'] != c1 || assigned[c1-'a'] != c2){
                    return false;
                }
            }
        }

        return true;
    }

    private String build(int board[][], int r, int c, int m, int n){
        if(r + m > board.length || c + n > board[0].length) return "";
        StringBuilder res = new StringBuilder();
        for(int i=r;i < r + m;i++){
            for(int j=c;j<c +n;j++){
                res.append(board[i][j]+":");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}