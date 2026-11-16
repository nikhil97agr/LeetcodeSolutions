package add_minimum_number_of_rungs_2066;

class Solution {
    public int addRungs(int[] rungs, int dist) {
        int start = 0;
        int count = 0;
        for(int x : rungs){
            if(x-start>dist){
                count += (x-start-1)/dist;
            }
            start = x;
        }

        return count;
    }

}