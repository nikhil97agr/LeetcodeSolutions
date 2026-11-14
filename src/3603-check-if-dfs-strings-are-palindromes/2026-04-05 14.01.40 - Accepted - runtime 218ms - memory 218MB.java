class Solution {
    boolean ans[];
    List<Integer> adjList[];
    char ch[];
    int hash[];
    int reHash[];
    int pow[];
    int mod = 1_000_000_007;
    int base = 31;
    public boolean[] findAnswer(int[] parent, String s) {
        int n =parent.length;
        ch = s.toCharArray();
        adjList = new ArrayList[n];
        hash = new int[n];
        reHash = new int[n];
        ans = new boolean[n];

        
        pow = new int[n+1];

        Arrays.fill(pow, 1);
        for(int i=1;i<=n;i++){
            pow[i] = prod(pow[i-1], base);
        }
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int i=1;i<n;i++){
            adjList[parent[i]].add(i);
        }

        dfs(0);
        redfs(0);

        for(int i=0;i<n;i++){
            ans[i] = hash[i] == reHash[i];
        }

        return ans;
    }

    private int[] dfs(int curr){
        int cnt = 0;
        int hash = 0;

        for(int child : adjList[curr]){
            int par[] = dfs(child);
            if(cnt ==0){
                hash = par[0];
            }else{
                hash = add(hash, prod(par[0], pow[cnt]));;
            }
            cnt += par[1];
        }

        hash = add(hash, prod(pow[cnt], ch[curr] - 'a'));
        this.hash[curr] = hash;

        cnt++;
        return new int[]{hash, cnt};
    }

    private int[] redfs(int curr){
        int cnt = 1;
        int hash = ch[curr] - 'a';
        for(int i = adjList[curr].size() - 1;i>=0;i--){
            int par[] = redfs(adjList[curr].get(i));

            hash = add(hash, prod(par[0], pow[cnt]));
            cnt += par[1];
        }

        reHash[curr] = hash;

        return new int[]{hash, cnt};

    }
    
    private int add(int a, int b){
        long s = 1l * a + b;
        return (int)(s%mod);
    }

    private int prod(int a, int b){
        long p = 1l * a *b;
        return (int)(p%mod);
    }
}