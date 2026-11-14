class Solution {
    public int removeAlmostEqualCharacters(String word) {
        Integer dp[] = new Integer[word.length()];
        return solve(word.toCharArray(), 0, dp);
    }

    private int solve(char ch[], int i, Integer dp[]){
        if(i >= ch.length){
            return 0;
        }

        if(dp[i] != null) return dp[i];
        int ind = ch[i] - 'a';
        boolean left = false;
        boolean change = false;
        if(i - 1 >=0){
            int ind2 =  ch[i-1] - 'a';
            if(Math.abs(ind - ind2) <= 1)
                {
                    left = true;
                    change= true;
                }
        }

        if(i + 1 < ch.length){
            int ind2 = ch[i+1] - 'a';
            if(Math.abs(ind - ind2) <= 1){
                change =true;
            }
        }

        if(!change){
            return dp[i] = solve(ch, i+1, dp );
        }

        else{
            int ans = 1 + solve(ch, i+2, dp);

            if(i+ 1 < ch.length && !left){
                   int i1 = ch[i+1] - 'a';
                   if(i+2 < ch.length){
                        int i2 = ch[i+2] - 'a';
                        if(Math.abs(i1 - i2) <= 1){
                            ans = Math.min(ans, 1 + solve(ch, i+3, dp));
                        }
                   } 
            }

            return dp[i] = ans;

        }

    }



}