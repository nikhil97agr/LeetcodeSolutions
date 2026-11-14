class Solution {
    public int getPermutationIndex(int[] perm) {
        int n = perm.length;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++) list.add(i);
        int ans = 0;
        List<Integer> vis= new ArrayList<>();
        int fact[] = new int[n+1];
        fact[0] = fact[1] = 1;
        for(int i=2;i<=n;i++){
            fact[i] = prod(fact[i-1], i);
        }
        for(int i=0;i<perm.length;i++){
            int cnt = find(list, perm[i]) - find(vis, perm[i]);
            ans = add(ans, prod(cnt, fact[n-i-1]));
            int ind = Collections.binarySearch(vis, perm[i]);
            if(ind < 0){
                ind = -ind - 1;

            }
            if(ind == vis.size()){
                vis.add(perm[i]);
            }else
            vis.add(ind, perm[i]);
        }
        return ans;
    }

    private int add(long a, long b){
        long mod = (long)1e9 + 7;
        long sum = a+b;
        return (int)(sum%mod);
    }

    private int prod(long a, long b){
        long mod = (long) 1e9 + 7;
        long prod = a * b;

        return (int)(prod%mod);
    }

    private int find(List<Integer> list, int val){
        int cnt = 0;
        int start = 0;
        int end = list.size()-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(list.get(mid) >= val){
                end = mid -1;
            }else{
                cnt = mid + 1;
                start = mid + 1;
            }
        }

        return cnt;
    }
}