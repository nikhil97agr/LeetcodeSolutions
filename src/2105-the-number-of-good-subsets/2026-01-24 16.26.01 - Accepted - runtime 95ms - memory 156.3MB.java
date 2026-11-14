import java.util.*;

class Solution {
    int mod = (int)1e9 + 7;

    // allowed primes
    int[] primes = {2,3,5,7,11,13,17,19,23,29};
    Map<Integer,Integer> idx = new HashMap<>();

    public int numberOfGoodSubsets(int[] nums) {

        for(int i=0;i<10;i++) idx.put(primes[i], i);

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> maskMap = new HashMap<>();

        for(int num : nums){
            if(num == 1){
                map.merge(1, 1, Integer::sum);
                continue;
            }

            int x = num;
            int mask = 0;
            boolean ok = true;

            for(int p : primes){
                if(p * p > x) break;
                if(x % p == 0){
                    int cnt = 0;
                    while(x % p == 0){
                        x /= p;
                        cnt++;
                    }
                    if(cnt > 1){
                        ok = false;
                        break;
                    }
                    mask |= (1 << idx.get(p));
                }
            }

            if(x > 1){
                if(!idx.containsKey(x)) ok = false;
                else mask |= (1 << idx.get(x));
            }

            if(ok){
                maskMap.put(num, mask);
                map.merge(num, 1, Integer::sum);
            }
        }

        List<Integer> cnt = new ArrayList<>();
        List<Integer> mask = new ArrayList<>();
        for(int x : maskMap.keySet()){
            cnt.add(map.get(x));
            mask.add(maskMap.get(x));
        }

        int ans = solve(0, cnt, mask, 0, cnt.size());

        return prod(ans, pow(2, map.getOrDefault(1, 0)));
    }

    private int solve(int currMask, List<Integer> cnt, List<Integer> mask, int i, int n){
        if(i == n){
            return currMask == 0 ? 0 : 1;
        }

        int ans = solve(currMask, cnt, mask, i + 1, n);

        if((currMask & mask.get(i)) == 0){
            ans = add(ans,

                    prod(cnt.get(i), solve(currMask | mask.get(i), cnt, mask, i + 1, n))
            );
        }

        return ans;
    }

    private int add(long a, long b){
        return (int)((a + b) % mod);
    }

    private int prod(long a, long b){
        return (int)((a * b) % mod);
    }

    private int pow(long a, long b){
        long res = 1, base = a;
        while(b > 0){
            if((b & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            b >>= 1;
        }
        return (int)res;
    }
}
