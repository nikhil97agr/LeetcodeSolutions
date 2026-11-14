import java.util.ArrayList;
import java.util.List;

class Solution {

    int mod = 1_000_000_007;
    List<Integer> list[];
    int nums[];
    int k;

    public int countValidSubsets(int[] parent, int[] nums, int k) {

        this.nums = nums;
        this.k = k;
        int n = parent.length;
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            list[parent[i]].add(i);
        }

        var res = dfs(0);


        return add(res.incl[0], add(res.excl[0], -1));
    }

    private Result dfs(int node) {

        int incl[] = new int[k];
        int excl[] = new int[k];
        incl[nums[node] % k] = 1;
        excl[0] = 1;

        for (int child : list[node]) {

            Result childRes = dfs(child);
            int tempIncl[] = new int[k];
            int tempExcl[] = new int[k];

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    int newMod = (i + j) % k;
                    tempIncl[newMod] = add(tempIncl[newMod], prod(incl[i], childRes.excl[j]));
                    tempExcl[newMod] = add(tempExcl[newMod], prod(excl[i], add(childRes.incl[j], childRes.excl[j])));
                }

            }

            incl = tempIncl;
            excl = tempExcl;


        }

        return new Result(incl, excl);


    }

    private int add(int a, int b) {

        long sum = 1l * a + b + mod;

        return (int) (sum % mod);
    }

    private int prod(int a, int b) {

        long p = 1l * a * b;
        return (int) (p % mod);
    }

    class Result {

        int incl[];
        int excl[];

        public Result(int incl[], int excl[]) {

            this.incl = incl;
            this.excl = excl;
        }
    }

}