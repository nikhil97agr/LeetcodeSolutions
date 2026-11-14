class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        rewardValues = sorted(rewardValues)
        ans = 1
        for val in rewardValues:
            newVal = ans & ((1<<val) - 1)
            ans |= (newVal << val)
        
        return ans.bit_length() - 1
        