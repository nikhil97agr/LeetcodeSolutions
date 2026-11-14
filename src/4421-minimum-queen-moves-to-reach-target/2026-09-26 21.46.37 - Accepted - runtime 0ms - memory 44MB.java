class Solution {
    public int minQueenMoves(int[] source, int[] target) {


        int a = Math.abs(source[0] - target[0]);
        int b = Math.abs(source[1] - target[1]);
        if(a==0 && b==0) return 0;

        if(a==0 || b== 0 || a== b) return 1;
        return 2;
        
    }
}