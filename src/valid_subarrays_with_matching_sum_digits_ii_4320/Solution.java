package valid_subarrays_with_matching_sum_digits_ii_4320;

import java.util.*;
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        long maxSum = 1_000_000_000_000_00L;

        List<List<Long>> reminders = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            reminders.add(new ArrayList<>());
        }

        reminders.get(0).add(0l);
        long pre = 0;
        int ans = 0;

        for (int y : nums) {
            pre += y;

            int targetLastDigit = (int)((pre - x + 10) % 10);
            List<Long> list = reminders.get(targetLastDigit);

            long power10 = 1;
            while (power10 <= pre) {
                long higher = pre - x * power10;
                long lower = pre - ((x + 1) * power10 - 1);

                    int lowerCount = bsLeft(list, lower);
                    int higherCount = bsRight(list, higher);
                    ans += (higherCount - lowerCount);

                if (power10 > maxSum) {
                    break;
                }
                power10 *= 10;

            }

            int dig = (int) (pre % 10);
            reminders.get(dig).add(pre);

        }

        return ans;
    }

    private int bsRight(List<Long> list, long target){
        int start = 0;
        int end = list.size() - 1;
        int cnt = 0;

        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) <= target){
                cnt = mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return cnt;
    }

    private int bsLeft(List<Long> list, long target){
        int start = 0;
        int end = list.size() - 1;
        int cnt = 0;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid) < target){
                cnt = mid + 1;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return cnt;
    }
}
