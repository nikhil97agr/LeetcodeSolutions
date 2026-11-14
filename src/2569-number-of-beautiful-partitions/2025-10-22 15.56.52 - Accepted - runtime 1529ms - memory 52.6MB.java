class Solution {
    Integer dp[][];

    public int beautifulPartitions(String s, int k, int minLength) {
        Set<Character> nonPrime = Set.of('1', '4', '6', '8', '9');
        Set<Character> prime = Set.of('2', '3', '5', '7');
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char dig = s.charAt(i);
            if (nonPrime.contains(dig)) {
                list.add(i);
            }
        }
        dp = new Integer[s.length()][k + 1];
        return solve(0, k, minLength, s.toCharArray(), s.length(), nonPrime, prime, list);
    }

    private int solve(int i, int k, int minLength, char ch[], int n, Set<Character> np, Set<Character> p,
            List<Integer> list) {
        if (i == n && k == 0)
            return 1;
        if (i == n || k == 0)
            return 0;
        if (dp[i][k] != null)
            return dp[i][k];
        int ans = 0;
        if (p.contains(ch[i])) {
            int nextInd = find(list, i + minLength - 1);
            if (nextInd != -1) {
                for (int j = nextInd; j < list.size(); j++) {
                        ans = add(ans, solve(list.get(j)+1, k - 1, minLength, ch, n, np, p, list));
                }
            }

        }

        return dp[i][k] = ans;
    }

    private int find(List<Integer> list, int val) {
        int start = 0;
        int end = list.size() - 1;
        int ind = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < val) {
                start = mid + 1;
            } else {
                ind = mid;
                end = mid - 1;
            }
        }

        return ind;
    }

    private int add(int a, int b) {
        long mod = (long) 1e9 + 7;
        long sum = mod + a + b;

        return (int) (sum % mod);
    }
}