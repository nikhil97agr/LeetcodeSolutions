package minimum_moves_to_reach_target_in_grid_3922;

class Solution {
    public int minMoves(int sx, int sy, int tx, int ty) {
        if(sx== tx && sy == ty) return 0;
        if(sx ==0 && sy ==0) return -1;

        int ans = 0;

        while(sx != tx || sy != ty){
            if(sx > tx || sy > ty) return -1;
            
            ans++;

            if(tx > ty){
                if( tx > ty*2){
                    if(tx%2!=0) return -1;
                    tx/=2;
                }else{
                    tx-=ty;
                }
            }else if(ty > tx){
                if(ty > tx*2){
                    if(ty%2!=0) return -1;
                    ty/=2;
                }else{
                    ty-=tx;
                }
            }else{
                if(sx ==0){
                    tx = 0;
                }else if(sy == 0){
                    ty = 0;
                }else{
                    return -1;
                }
            }
        }

        return ans;
    }
}