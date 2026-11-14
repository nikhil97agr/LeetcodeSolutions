package pour_water_756;

class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        int n = heights.length;
        for(int i=0;i<volume;i++){
            int ind = k;
            int prev = k;
            while(ind >= 0){
                if(heights[ind] < heights[prev]){
                    prev = ind;
                }else if(heights[ind] > heights[prev]) break;
                ind--;
            }

            if(prev !=k){
                heights[prev]++;
                continue;
            }

            ind = k;
            prev = k;

            while(ind < n){
                if(heights[ind] < heights[prev]){
                    prev = ind;
                }else if(heights[ind] > heights[prev]) break;
                ind++;
            }


            heights[prev]++;
        }


        return heights;
    }
}