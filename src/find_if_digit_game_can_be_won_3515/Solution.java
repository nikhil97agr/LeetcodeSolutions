package find_if_digit_game_can_be_won_3515;

import java.util.*;
class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = Arrays.stream(nums).filter(n -> n < 10).sum();
        int sum2 = Arrays.stream(nums).filter(n -> n>=10).sum();
        return sum1 != sum2;
    }
}