import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int maxTotalReward(int[] rewardValues) {

        Arrays.sort(rewardValues);
        var dp = new HashMap<Integer, Integer>();
        
        var n = rewardValues.length;
        return rewardValues[n-1] + solve(rewardValues[n-1] -1, rewardValues, Arrays.stream(rewardValues).boxed().collect(
                Collectors.toSet()), dp);
    }

    private int solve(int nextValue, int nums[], Set<Integer> set, Map<Integer, Integer> dp) {

        if (dp.containsKey(nextValue)) {
            return dp.get(nextValue);
        }

        if (nextValue == 0 || set.contains(nextValue)) {
            return nextValue;
        }

        int ind = binarySearch(nums, nextValue);

        int ans = 0;
        for(int i=0;i<=ind;i++){
            ans= Math.max(ans, nums[i] + solve(Math.min(nextValue - nums[i], nums[i] - 1), nums, set, dp));
        }
        
        dp.put(nextValue, ans);
        
        return ans;
    }

    private int binarySearch(int nums[], int val) {

        int ind = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < val) {
                ind = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ind;
    }
}