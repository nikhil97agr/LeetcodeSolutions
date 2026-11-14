package gas_station_134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        int current = 0;
        int index =0 ;
        int n =cost.length;
        for(int i=0;i<n;i++){
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if(current<0){
                current = 0;
                index = i+1;
            }
        }

        if(total < 0){
            index = -1;
        }
        return index;
    }
}