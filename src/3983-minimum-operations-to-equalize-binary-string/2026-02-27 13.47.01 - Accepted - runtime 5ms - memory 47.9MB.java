class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for(char c : s.toCharArray()) if(c=='0') z++;

        if(z==0) return 0;
        if(n==k){
            if(z == n) return 1;
            return -1;
        }

        int o = n - z;
        int base = n- k;
        long ans = Long.MAX_VALUE;

        if(k%2 == z%2){
            long m = Math.max((z +k-1)/k, (o + base -1)/base);
            if(m%2==0) m++;
            ans = Math.min(ans, m);
        } 

        if(z%2==0){
            long m = Math.max((z + k -1)/k, (z + base-1)/base);

            if(m%2==1) m++;
            ans = Math.min(ans, m);
        }
        if(ans == Long.MAX_VALUE) return -1;
        return (int)ans;
    }

    
}