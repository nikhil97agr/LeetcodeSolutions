class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Integer> map = new HashMap<>();

        for(int r[] : rectangles){
            int a= r[0];
            int b= r[1];
            int gcd= gcd(a,b);
            a/=gcd;
            b/=gcd;
            String s = a+":"+b;

            map.merge(s, 1, Integer::sum);
        }

        long ans = 0;

        for(int c : map.values()){
            ans += (1l*c*(c-1))/2;
        }

        return ans;


    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}