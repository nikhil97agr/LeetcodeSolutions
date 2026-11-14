package robot_return_to_origin_657;

class Solution {
    public boolean judgeCircle(String moves) {
        int r = 0;
        int c = 0;
        for(char ch : moves.toCharArray()){
            switch(ch){
                case 'U': r--;
                break;
                case 'L':c--;
                break;
                case 'R':c++;
                break;
                case 'D' : r++;
                break;
            }
        }

        return r==0 && c == 0;
    }
}