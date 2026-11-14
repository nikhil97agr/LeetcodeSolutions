package pass_the_pillow_2645;

class Solution {
    public int passThePillow(int n, int time) {
        int div = time/(n-1);
        if((div&1)==1){
            return n - (time%(n-1));
        }else{
            return 1 + (time%(n-1));
        }
    }
}