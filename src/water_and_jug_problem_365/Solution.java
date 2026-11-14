package water_and_jug_problem_365;

class Solution {
    public boolean canMeasureWater(int j1, int j2, int res) {
        if(j1+j2<res) return false;
        if(j1==res || j2 == res || j1+j2 == res) return true;

        return (res %(gcd(j1,j2))==0) ;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}