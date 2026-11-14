package reaching_points_796;

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty) return false;
        while(sx < tx && sy < ty){
            if(tx > ty) tx = tx%ty;
            else ty = ty%tx;
        }
        System.out.println(sx+":"+tx+":"+ty+":"+sy);
        if(sx == tx){
            return (sy - ty)%tx == 0;
        }else if(sy == ty){
            return (sx-tx)%ty == 0;
        }
        return false;
    }
}