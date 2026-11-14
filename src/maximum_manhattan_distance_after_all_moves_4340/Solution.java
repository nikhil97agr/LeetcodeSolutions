package maximum_manhattan_distance_after_all_moves_4340;

class Solution {
    public int maxDistance(String moves) {
        int ans = 0;
        int x =0 ;
        int y = 0;
        int cnt = 0;
        for(char c : moves.toCharArray()){
            if( c == '_'){
                cnt++;
            }else if(c=='U'){
                if( y > 0){
                    ans--;
                }else{
                    ans++;
                }
                y--;
            }else if(c== 'L'){
                if(x >0){
                    ans--;
                }else{
                    ans++;
                }
                x--;
            }else if(c=='R'){
                if( x < 0){
                    ans--;
                }else{
                    ans++;
                }
                x++;
            }else if( c == 'D'){
                if( y < 0){
                    ans--;
                    
                }else{
                    ans++;
                }
                y++;
            }
        }

        return ans + cnt;
    }
}