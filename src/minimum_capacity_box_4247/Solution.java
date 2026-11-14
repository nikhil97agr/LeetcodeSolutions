package minimum_capacity_box_4247;

class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ind = -1;
        int val = 10001;
        int n =capacity.length;
        for(int i=0;i<n;i++){
            if(capacity[i] >= itemSize){
                if(capacity[i] < val){
                    val = capacity[i];
                    ind = i;
                }
            }
        }

        return ind;
    }
}