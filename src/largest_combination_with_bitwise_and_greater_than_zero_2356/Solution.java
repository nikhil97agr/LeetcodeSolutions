package largest_combination_with_bitwise_and_greater_than_zero_2356;

class Solution {
    public int largestCombination(int[] candidates) {
              int ans = 0;
                      for (int i = 0; i < 32; i++) {
                                  int cnt = 0;
                                              for (int candidate : candidates) {
                                                              if ((candidate & (1 << i)) != 0) cnt++;
                                                                          }
                                                                                      ans = Math.max(ans, cnt);
                                                                                              }
                                                                                                      return ans;
    }
}