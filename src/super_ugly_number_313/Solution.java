package super_ugly_number_313;

import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        TreeSet<Long> q1 = new TreeSet<>();
        q1.add(1L);
        TreeSet<Long> q2 = new TreeSet<>(Collections.reverseOrder());
        q2.add(1L);
        while(!q1.isEmpty()){

            long y = q1.pollFirst();
            for(long x : primes){
                long z = x*y;
                if(q2.size() < n){
                    q2.add(z);
                    q1.add(z);
                }else{

                    if(z < q2.first() && !q2.contains(z)){
                        q2.pollFirst();
                        q1.add(z);
                        q2.add(z);
                    }
                }
            }

        }

        return Math.toIntExact(q2.first());

    }
}