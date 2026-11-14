class Solution {
    public long fixedRatio(String s, int num1, int num2) {
       long ans = 0;
       int n = s.length();
       Map<Long, Integer> map = new HashMap<>(); 
       long cnt = 0;
       int total = num1 + num2;
       for(int i=0;i<n;i++){
        if(s.charAt(i) == '0'){
            cnt++;
        }

        long req = cnt * total - i * num1;

        ans+= map.getOrDefault(req, 0);
        if(same(cnt, i+1, num1, num2)){
            ans++;
        }
        map.merge(req, 1, Integer::sum);

       }

       return ans;
    }

    private boolean same(long cnt, int n, int a, int b){
        int c1 = (int)cnt;
        int c2 = n- c1;

        int gcd = gcd(c1, c2);
        c1/=gcd;
        c2 /=gcd;

        return c1 == a && c2 == b;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}