package count_zero_request_servers_2833;

import java.util.*;
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q = queries.length;
        Arrays.sort(logs, (a, b) -> {
            return a[1] - b[1];
        });

        int query[][] = new int[q][2];
        for (int i = 0; i < q; i++) {
            query[i] = new int[] { queries[i], i };
        }
        Arrays.sort(query, (a, b) -> a[0] - b[0]);
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[q];
        for (int que[] : query) {
            int start = que[0] - x;
            int end = que[0];

            while (i < logs.length && logs[i][1] <= end) {
                add(map, logs[i][0]);
                i++;
            }
            while (!map.isEmpty() && j <= i && logs[j][1] < start) {
                remove(map, logs[j][0]);
                j++;

            }

            ans[que[1]] = n - map.size();

        }

        return ans;
    }

    private void add(Map<Integer, Integer> map, int val) {
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val) {
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0)
            map.remove(val);
    }

}