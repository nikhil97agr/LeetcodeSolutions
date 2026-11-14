class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int ans = Math.min(numOnes, k);
        k -= Math.min(numOnes, k);
        k -= Math.min(numZeros, k);
        ans += -1*(Math.min(numNegOnes, k));
        return ans;
    }
}