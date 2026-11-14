package valid_k_unique_subarrays_i_3988;

import java.util.*;
class Solution {
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        for (int i = 0; i < q; i++) {
            queries[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        int block = (int) Math.sqrt(n);

        Arrays.sort(queries, (a, b) -> {
            int b1 = a[0] / block;
            int b2 = b[0] / block;

            if (b1 == b2)
                return a[1] - b[1];

            return b1 - b2;
        });

        boolean ans[] = new boolean[q];
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt[] = new int[max + 1];
        Set<Integer> set = new HashSet<>();
        int oddCount = 0;
        int l = 0;
        int r = -1;
        for (var que : queries) {
            var ql = que[0];
            var qr = que[1];

            while (l > ql) {
                l--;
                int val = nums[l];
                cnt[val]++;
                if (cnt[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                if(cnt[val] == 0){
                    set.remove(val);
                }else if(Math.abs(cnt[val]) == 1){
                    set.add(val);
                }

            }

            while (r < qr) {
                r++;
                int val = nums[r];
                cnt[val]++;
                if (cnt[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                 if(cnt[val] == 0){
                    set.remove(val);
                }else if(Math.abs(cnt[val]) == 1){
                    set.add(val);
                }

            }

            while (l < ql) {
                int val = nums[l];
                cnt[val]--;
                if (cnt[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }
                if(cnt[val] == 0){
                    set.remove(val);
                }else if(Math.abs(cnt[val]) == 1){
                    set.add(val);
                }

                l++;
            }

            while (r > qr) {
                int val = nums[r];
                cnt[val]--;
                if (cnt[val] % 2 == 0) {
                    oddCount++;
                } else {
                    oddCount--;
                }

                if(cnt[val] == 0){
                    set.remove(val);
                }else if(Math.abs(cnt[val]) == 1){
                    set.add(val);
                }

                r--;
            }

            if (set.size() == k && oddCount == 0) {
                ans[que[2]] = true;
            } else {
                ans[que[2]] = false;
            }

        }

        return ans;

    }

}