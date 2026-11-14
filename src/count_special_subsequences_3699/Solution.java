package count_special_subsequences_3699;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;

        Map<Pair, Integer> map = new HashMap<>();

        long ans = 0;

        for(int r=4;r<n-2;r++){
            int q = r - 2;
            for(int p=0;p<=q-2;p++){
                int gcd =gcd(nums[p], nums[q]);
                int a= nums[p]/gcd;
                int b = nums[q]/gcd;
                map.merge(new Pair(a,b), 1, Integer::sum);
            }

            for(int s = r+2;s<n;s++){
                int gcd = gcd(nums[s], nums[r]);
                int a = nums[s]/gcd;
                int b = nums[r]/gcd;
                ans += map.getOrDefault(new Pair(a,b), 0);
            }
        }



        return ans;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }

    class Pair{
        int num;
        int den;
        public Pair(int num, int den){
            this.num = num;
            this.den = den;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return num == pair.num && den == pair.den;
        }

        @Override
        public int hashCode() {

            return Objects.hash(num, den);
        }
    }
}