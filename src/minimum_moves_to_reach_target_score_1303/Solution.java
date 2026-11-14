package minimum_moves_to_reach_target_score_1303;

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int move=0;
        while(target>1&&maxDoubles>0){
            if(target%2==0){
                target/=2;
                move++;
                maxDoubles--;
            }else{
                target--;
                move++;
            }
        }
        if(target!=1){
            move += target-1;
        }
        return move;
    }
}