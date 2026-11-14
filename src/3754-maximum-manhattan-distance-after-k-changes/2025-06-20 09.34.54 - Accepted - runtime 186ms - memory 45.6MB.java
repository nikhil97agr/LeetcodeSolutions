class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        ans = Math.max(
            solve('N', 'E', k, s),
            Math.max(
                solve('N', 'W', k, s),
                Math.max(solve('S', 'E', k, s), 
                solve('S', 'W', k, s))
            )
        );

        return ans;
    }

    private int solve(char v, char h, int k, String s){
        int sum = 0;
        int ans = 0;
        
        int x =0;
        int y=0;
        for(char c : s.toCharArray()){
            switch(c){
                case 'N':
                if(v=='N'){
                    x++;
                }else{
                    if(k>0){
                        x--;
                        k--;
                    }else{
                        x++;
                    }
                }
                break;
                case 'E':
                if(h=='E'){
                    y++;
                }else{
                    if(k>0){
                        y--;
                        k--;
                    }else{
                        y++;
                    }
                }
                break;
                case 'W':
                if(h=='W'){
                    y--;
                }else{
                    if(k>0){
                        y++;
                        k--;
                    }else{
                        y--;
                    }
                }
                break;
                case 'S':
                if(v=='S'){
                    x--;
                }else{
                    if(k>0){
                        x++;
                        k--;
                    }else{
                        x--;
                    }
                }
                break;
            }
            ans = Math.max(ans, Math.abs(x) + Math.abs(y));
        }

        return ans;
    }
}