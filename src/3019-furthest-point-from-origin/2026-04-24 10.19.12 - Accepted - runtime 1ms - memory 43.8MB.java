class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0;
        int r=0;
        int rest = 0;
        for(char c : moves.toCharArray()){
            switch(c){
                case 'L': l++;break;
                case 'R': r++;break;
                default: rest++;
            }
        }

        return rest + Math.max(l,r) - Math.min(l,r);
    }
}