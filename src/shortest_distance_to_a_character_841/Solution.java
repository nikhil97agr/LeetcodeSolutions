package shortest_distance_to_a_character_841;

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int ans[] = new int[n];

        int ind = -100000000;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == c){
                ind = i;
            
            }else{
                ans[i] = i - ind;
            }
        }

        ind = (int)1e8;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == c) {
                ans[i] = 0;
                ind  = i;
            }else{
                ans[i] = Math.min(ind - i, ans[i]);
            }
        }

        return ans;
    }
}