class Solution {
    int mod = 1_000_000_007;
    public int numberOfSequence(int n, int[] sick) {
        List<Integer> list = new ArrayList<>();
        list.add(sick[0]);
        for(int i=1;i<sick.length;i++){
            int cnt = sick[i] - sick[i-1] - 1;
            if(cnt > 0){
                list.add(cnt);
            }
        }


        list.add(n - sick[sick.length - 1] - 1);
        int total = list.stream().reduce(0, Integer::sum);
        int fact[] = new int[total + 1];
        int inv[] = new int[total + 1];
        fact[0] = fact[1] = inv[0] = inv[1] = 1;
        for(int i=2;i<fact.length;i++){
            fact[i] = prod(fact[i-1], i);
        }
        inv[total] = pow(fact[total], mod - 2);
        for(int i=total-1;i>1;i--){
            inv[i] = prod(inv[i+1], i + 1);
        }


        int ans = fact[total];
        for(int i=0;i<list.size();i++){
            ans = prod(ans, inv[list.get(i)]);

            if( i !=0 && i != list.size()-1){
                ans = prod(ans, pow(2, list.get(i) - 1));
            }
        }

        return ans;
        
    }

    private int prod(int a, int b){
        long p = 1l * a * b;
        return (int)(p%mod);
    }

    private int pow(int a, int b){
        int p = 1;
        while ( b > 0){
            if(b%2==1){
                 p = prod(p, a);
            }
            a = prod(a,a);
            b>>=1;
        }

        return p;
    }
}