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