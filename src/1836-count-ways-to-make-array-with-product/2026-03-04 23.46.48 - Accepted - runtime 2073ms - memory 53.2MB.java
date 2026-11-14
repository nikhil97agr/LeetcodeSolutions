import java.util.HashMap;
import java.util.Map;

class Solution {
    long mod = (long) 1e9 + 7;
    public int[] waysToFillArray(int[][] queries) {
        int q= queries.length;
        int ans[] = new int[q];
        Arrays.fill(ans, 1);
        int fact[] = new int[100000];
        int invFact[] = new int[100000];
        
        fact[0] = fact[1] = 1;
        invFact[0] = invFact[1] = 1;
        
        for(int i=2;i<100000;i++){
            fact[i] = prod(fact[i-1], i);
            invFact[i] = pow(fact[i], mod -2);
        }
        
        for(int i=0;i<q;i++){
            int n = queries[i][0];
            int k = queries[i][1];
            Map<Integer, Integer> factors = factors(k);
            for(int val : factors.values()){
                ans[i] = prod(ans[i], comb(n+val -1, val, fact, invFact));
            }
        }
        
        
        return ans;
    }
    
    private int comb(int n, int r, int fact[], int invFact[]){
        return prod(fact[n], prod(invFact[r], invFact[n-r]));
    }
    
    private Map<Integer, Integer> factors(int k){

        Map<Integer, Integer> map = new HashMap<>();
        while(k%2==0){
            map.merge(2, 1, Integer::sum);
            k/=2;
        }
        
        for(int i=3;i<=Math.sqrt(k);i++){
            while(k%i==0){
                k/=i;
                map.merge(i, 1, Integer::sum);
            }
        }
        if(k  > 1){
            map.merge(k, 1, Integer::sum);
        }
        
        return map;
    }
    
    private int add(long a, long b){
        return (int)((a%mod + b%mod)%mod);
    }
    
    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
    
    private int pow(long a, long b){
        if(b==1 || a==0) return prod(a,1);
        if(b==0) return 1;
        
        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }
        
        return p;
    }
}