import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Integer, List<int[]>> queryMap;
    int ans[];
    List<Integer> list[];
    int vals[];

    public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {

        this.vals = vals;
        queryMap = new HashMap<>();
        ans = new int[queries.length];
        int n = vals.length;
        Arrays.fill(ans, -1);
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            list[par[i]].add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int k = queries[i][1];
            queryMap.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{i, k});
        }

        dfs(0, 0);

        return ans;
    }

    private List<Integer> dfs(int u,  int currXor) {

        List<Integer> xor = new ArrayList<>();
        var newXor= currXor ^ vals[u];
        xor.add(newXor);
        for (int child : list[u]) {


            List<Integer> childXor = dfs(child,  newXor);

            if(childXor.size() > xor.size()){
                var temp = xor;
                xor = childXor;
                childXor= temp;
            }

            for (var x : childXor) {

                var index = Collections.binarySearch(xor, x);
                if (index < 0) {
                    index = -index - 1;
                    if (index == xor.size()) {
                        xor.add(x);
                    } else {
                        xor.add(index, x);
                    }
                }
            }

        }

        for (var entry : queryMap.getOrDefault(u, new ArrayList<>())) {
            int ind = entry[0];
            int k = entry[1] - 1;

            if (k < xor.size()) {
                ans[ind] = xor.get(k);
            }
        }

        return xor;
    }
}