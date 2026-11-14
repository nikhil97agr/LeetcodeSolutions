class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char dig[] = s.toCharArray();
        for(int i=0;i<dig.length-1;i++){
            int d1 = dig[i] - '0';
            int d2 = dig[i+1] - '0';

            int diff = Math.abs(d1 -d2);
            if(diff  > 2){
                return false;
            }
        }
        return true;
    }
}