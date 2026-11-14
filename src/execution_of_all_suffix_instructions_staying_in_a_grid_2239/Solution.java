package execution_of_all_suffix_instructions_staying_in_a_grid_2239;

class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int ans[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            ans[i] = cnt(startPos[1], startPos[0], i, s, n);
        }

        return ans;
    }

    private int cnt(int x, int y, int i, String s, int n){
        int cnt = 0;

        while(i<s.length() && x >=0 && x < n && y >=0 && y< n){
            char ch = s.charAt(i);

            switch(ch){
                case 'R' :  x++; break;
                case 'D': y++; break;
                case 'L': x--; break;
                case 'U': y--; break;
            }
            i++;
            cnt++;
        }

        if( x < 0 ||  y < 0 || x>=n|| y>=n) return cnt-1;



        return cnt;
    }
}