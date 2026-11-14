package number_of_distinct_binary_strings_after_applying_operations_2593;

class Solution {
    public int countDistinctStrings(String s, int k) {
        return pow(2, s.length() -k  +1);
    }

    private int pow(int a, int b){
        if(b ==0 ) return 1;
        if(b==1) return a;

        int p = pow(a, b/2);
        p = prod(p,p);

        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }
    
    private int prod(int a, int b){
        long mod = (long)1e9 + 7;

        return (int)((1l*a*b)%mod);
    }
}