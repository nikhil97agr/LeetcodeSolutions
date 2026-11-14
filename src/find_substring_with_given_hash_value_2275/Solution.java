package find_substring_with_given_hash_value_2275;

class Solution {

    int mod = 0;

    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        mod = modulo;
        int pk = pow(power, k);
        int hash = 0;
        int n = s.length();
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ind = s.charAt(i) - 'a' + 1;
            hash = add(prod(hash, power), ind);

            if (i + k < n) {
                int last = s.charAt(i+k) - 'a' + 1;
                hash = add(hash, - prod(pk, last));
            }
            
            if(hash == hashValue){
                ans = i;
            }


        }

        return s.substring(ans, ans + k);
    }

    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }

    private int pow(long a, long b) {

        if (a == 0 || b == 1) {
            return prod(a, 1);
        }
        if (b == 0) {
            return 1;
        }

        int p = pow(a, b / 2);
        p = prod(p, p);
        if (b % 2 == 1) {
            p = prod(p, a);
        }

        return p;
    }

}