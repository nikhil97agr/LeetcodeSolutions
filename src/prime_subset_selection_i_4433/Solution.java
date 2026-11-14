package prime_subset_selection_i_4433;

import java.util.*;
class Solution {

    static List<Integer> list = new ArrayList<>();

    {
        if (list.isEmpty()) {
            int n = 1_000_000;
            boolean primes[] = new boolean[n + 1];
            Arrays.fill(primes, true);
            primes[0] = primes[1] = false;
            for (int i = 2; i <= n; i++) {
                if (primes[i]) {
                    list.add(i);

                    int j = i + i;
                    while (j <= n) {
                        primes[j] = false;
                        j += i;
                    }
                }
            }
        }
    }

    public List<Integer> maxPrimes(int n, int s) {

        List<Integer> result = new ArrayList<>();

        for (int x : list) {
            if( x > n) break;
            if (x <= s) {
                result.add(x);
                s -= x;
            } else {
                break;
            }
        }

        return result;

    }
}