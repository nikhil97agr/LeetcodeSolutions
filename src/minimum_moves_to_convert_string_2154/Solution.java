package minimum_moves_to_convert_string_2154;

class Solution {
    public int minimumMoves(String s) {
        char res[] = s.toCharArray();
        int ans = 0;
        for(int i=0;i < res.length -2;i++){
            if(res[i] == 'X'){
                res[i] = res[i+1] = res[i+2] = '0';
                ans++;
            }
        }
        int n = res.length;
        if(res[n-1] == 'X' || res[n-2] == 'X') ans++;
        return ans;
    }
}