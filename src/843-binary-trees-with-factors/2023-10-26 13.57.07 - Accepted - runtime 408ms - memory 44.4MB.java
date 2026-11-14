class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
        long mod = (long) 1e9 + 7;
        Set<Integer> set = new HashSet<>();

        Map<Integer, Long> dp = new HashMap<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int x : arr) {
            dp.put(x, 1l);
            set.add(x);
        }
        for (int i = 0; i < n; i++) {
            solve(arr[i], i, dp, mod, arr, set);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp.get(arr[i]);
            ans %= mod;
        }
        return (int) ans;
    }

    private void solve(int num, int ind, Map<Integer, Long> dp, long mod, int arr[], Set<Integer> set) {
        for (int j=2;j<=Math.sqrt(num);j++) {
            if (num % j == 0) {
                int first = j;
                int sec = num/j;
                if(!set.contains(first) || !set.contains(sec)){
                    continue;
                }
                if (first == sec) {
                    dp.put(num, (dp.get(num) + (dp.get(first) * dp.get(sec)) % mod) % mod);
                } else  {
                    dp.put(num, (dp.get(num) + (dp.get(first) * dp.get(sec) * 2) % mod) % mod);
                }
            }
        }
    }
}