package minimum_cost_to_move_chips_to_the_same_position_1329;

class Solution {
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        int oddCount = 0;
        for(int x : position)
        {
            if(x%2==0)
                evenCount++;
            else
                oddCount++;
        }
        return Math.min(evenCount, oddCount);
    }
}