class Solution {
    public int countRotations(String s, int k) {
        int ans = 0;
        int score = 0;
        int n =s.length();
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                score++;
            }
        }

        for(int i=0,j = n-1;i<n;i++, j++){
            j%=n;

            if(score == k){
                ans++;
            }

            if(s.charAt(i) == s.charAt(j)){
                score++;
            }

            if(s.charAt(i) == (s.charAt((i+1)%n))){
                score--;
            }

        }

        return ans;
    }
}