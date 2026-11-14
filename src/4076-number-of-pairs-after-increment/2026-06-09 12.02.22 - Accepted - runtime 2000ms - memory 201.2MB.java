import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {

        var n = nums2.length;
        var result = new ArrayList<Integer>();

        var blockSize = (int) Math.sqrt(n);

        var block = (n + blockSize - 1) / blockSize;

        Map<Long, Integer> map[] = new HashMap[block];
        var transform = Arrays.stream(nums2).mapToLong(x -> 1L * x).toArray();
        for (int i = 0; i < block; i++) {
            map[i] = new HashMap<>();
            int start = i * blockSize;
            int end = Math.min((i + 1) * blockSize, n) - 1;
            for (int j = start; j <= end; j++) {
                add(map[i], transform[j]);
            }
        }

        var lazy = new long[block];

        for (var q : queries) {
            var type = q[0];
            if (type == 1) {
                var x = q[1];
                var y = q[2];
                var val = q[3];

                for (int i = x/blockSize; i < y/blockSize + 1; i++) {
                    int start = i * blockSize;
                    int end = Math.min((i + 1) * blockSize, n) - 1;
                    if (x <= start && end <= y) {
                        lazy[i] += val;
                    } else {
                        for (int j = start; j <= end; j++) {
                            if (x <= j && j <= y) {
                                remove(map[i], transform[j]);
                                transform[j] += val;
                                add(map[i], transform[j]);

                            }
                        }
                    }
                }
            } else {
                var total = q[1];

                int cnt = 0;

                for (var x : nums1) {

                    long req = total - x;

                    for (int i = 0; i < block; i++) {
                        long newReq = req - lazy[i];
                        cnt += map[i].getOrDefault(newReq, 0);
                    }
                }

                result.add(cnt);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();

    }

    private void remove(Map<Long, Integer> map, long val) {

        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) {
            map.remove(val);
        }
    }

    private void add(Map<Long, Integer> map, long val) {

        map.merge(val, 1, Integer::sum);
    }
}