package maximum_number_of_coins_you_can_get_1683;

import java.util.*;
class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int num : piles) {
            queue.addLast(num);
        }
        
        int ans = 0;
        while (!queue.isEmpty()) {
            queue.removeLast(); // alice
            ans += queue.removeLast(); // us
            queue.removeFirst(); // bob
        }
        
        return ans;
    }
}