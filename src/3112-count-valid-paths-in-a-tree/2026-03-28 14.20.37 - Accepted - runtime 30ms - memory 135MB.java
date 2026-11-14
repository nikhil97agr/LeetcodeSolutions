class Solution {
    boolean primes[];
    List<Integer> adjList[];
    public long countPaths(int n, int[][] edges) {
        primes = new boolean[n+1];
        adjList = new ArrayList[n];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for(int i=2;i<=n;i++){
            if(!primes[i]) continue;
            int j = i + i;

            while(j <=n){
                primes[j] = false;
                j += i;
            }
        }

        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int e[] : edges){
            int u = e[0] - 1;
            int v = e[1] - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Result result = dfs(0, -1);

        return result.ans;

    }

    private Result dfs(int curr, int par){
        Result result = new Result(
            primes[curr+1] ? 1 : 0,
            primes[curr+1] ? 0 : 1,
            0
        );

        for(int child : adjList[curr]){
            if(child == par) continue;

            Result childResult = dfs(child, curr);
            result.ans += childResult.ans + prod(childResult.withPrime, result.withoutPrime) + prod(childResult.withoutPrime, result.withPrime);

            if(primes[curr+1]){
                result.withPrime += childResult.withoutPrime;
            }else{
                result.withPrime += childResult.withPrime;
                result.withoutPrime += childResult.withoutPrime;
            }
        }

        return result;
    }

    private long prod(long a, long b){
        return a * b;
    }

    class Result{
        long withPrime;
        long withoutPrime;
        long ans;
        public Result(long with, long without, long ans){
            this.withPrime = with;
            this.withoutPrime =without;
            this.ans = ans;
        }

    }
}