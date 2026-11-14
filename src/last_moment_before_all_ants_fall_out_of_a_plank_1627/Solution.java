package last_moment_before_all_ants_fall_out_of_a_plank_1627;

import java.util.*;
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxLeft = Arrays.stream(left).max().orElse(0);
        int minRight = n-Arrays.stream(right).min().orElse(n);

        return Math.max(maxLeft, minRight);
    }
}