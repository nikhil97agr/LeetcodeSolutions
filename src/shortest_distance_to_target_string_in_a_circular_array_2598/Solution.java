package shortest_distance_to_target_string_in_a_circular_array_2598;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ind = -1;
        int ans = Integer.MAX_VALUE;
        int n = words.length;
        int start = startIndex;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                ind = i;
                if (start >= i) {
                    ans = Math.min(ans, start - i);
                    ans = Math.min(ans, n - start + i);
                } else {
                    ans = Math.min(ans, i - start);
                    ans = Math.min(ans, start + 1 + n - i - 1);
                }
            }
        }
        if (ind == -1) {
            return -1;
        }
        return ans;

    }
}