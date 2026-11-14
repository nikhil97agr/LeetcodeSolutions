package fruits_into_baskets_ii_3790;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        int m = baskets.length;
        int n = fruits.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(baskets[j] >= fruits[i]){
                    cnt++;
                    baskets[j]   = -1; 
                    break;
                }
            }
        }
       

        return n - cnt;
    }
}