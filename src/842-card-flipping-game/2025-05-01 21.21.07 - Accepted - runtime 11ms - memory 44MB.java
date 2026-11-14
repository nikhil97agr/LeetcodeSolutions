class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int max = 0;
        int n = fronts.length;
        for(int i=0;i<n;i++) max = Math.max(max, Math.max(fronts[i], backs[i]));
        for(int i=1;i<=max;i++){
            int count = 0;
            boolean res = true;
            for(int j=0;j<n;j++){
                if(fronts[j] == i){
                    if(backs[j] ==i){
                        res = false;
                        break;
                    }
                    count++;
                }else if(backs[j] == i){
                    count++;
                }
            }
            if(count > 0 && res) return i;
        }
        return 0;
    }
}