class Solution {
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);

        }
        if(k > map.size()) return 0;
        long ans = 1;
        long mod = (long)1e9+7;
        TreeMap<Integer, Integer> tree = new TreeMap<>((a,b) -> b-a);
        for(int val : map.values()){
            tree.put(val, tree.getOrDefault(val, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : tree.entrySet()){
            long cnt = entry.getValue();
            long key = entry.getKey();
            if(cnt <= k){
                for(long x =0;x<cnt;x++){
                    ans *= key;
                    ans %=mod;
                }
                k-=cnt;
            }else{
                long x = 1;
                for(int i=0;i<k;i++){
                    x *= key;
                    x%=mod;
                }
                long combos = calculateCombinations(cnt, k);
                x*=combos;
                x%=mod;
                ans *=x;
                ans%=mod;
                k=0;
            }

            if(k==0) return (int)ans;
        }
        return 0;
    }

    private long calculateCombinations(long n, long r){
        r = Math.min(r, n-r);

        long ans = 1;
        for(long i=n;i>n-r;i--){
            ans *= i;
        }

        for(long i=1;i<=r;i++){
            ans /= i;
        }

        return ans;
    }

}