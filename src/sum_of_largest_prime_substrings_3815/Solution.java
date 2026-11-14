package sum_of_largest_prime_substrings_3815;

import java.util.*;
class Solution {
    public long sumOfLargestPrimes(String s) {
        long ans = 0;
        Set<Long> set = new HashSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                String st = sb.toString();
                if(isPrime(st)){
                    set.add(Long.parseLong(st));
                }
            }
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);
        if(list.isEmpty()) return 0;
        if(list.size() ==1 ) return list.get(0);
        if(list.size() == 2){
            return list.get(0) + list.get(1);
        }
        int size = list.size();

        return list.get(size-1) + list.get(size - 2) + list.get(size - 3);
    }

    private boolean isPrime(String s){
        if(s.isEmpty()) return true;
        long num = Long.parseLong(s);

        if(num == 1) return false;
        if(num <= 3 ) return true;
        if(num%2==0) return false;

        for(long i=3;i<= Math.sqrt(num);i+=2){
            if(num%i==0) return false;
        }

        return true;
    }
}