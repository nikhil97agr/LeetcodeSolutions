class Solution {
    int spf[];
    private void smallesPrimeFactor(int max){
         spf = new int[max+1];

        for(int i=0;i<=max;i++){
            spf[i] = i;
        }

        for(int i=4;i<=max;i+=2){
            spf[i] = 2;
        }

        for(int i=3; i * i <= max;i+=2){
            if(spf[i] == i){
                for(int j = i * i;j <= max;j += i * 2){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }


    }

    private Set<Integer> getPrimes(int n){
        Set<Integer> set = new HashSet<>();

        while( n > 1){
            set.add(spf[n]);
            n/= spf[n];
        }

        return set;
    }

    private int[] getSub(int n){
        List<Integer> primes = new ArrayList<>(getPrimes(n));
        int m = primes.size();

        int subs[] = new int[ 1 << m];
        for(int mask = 0;mask < ( 1 << m);mask++){
            int val = 1;
            for(int j=0;j<m;j++){
                if((mask & (1 << j)) !=0){
                    val *= primes.get(j);
                }
            }
            subs[mask] = val;
        }

        return subs;

    }
    public int maxScore(int[] nums, int maxVal) {
        int max = Math.max(maxVal, Arrays.stream(nums).max().getAsInt()) + 1;

      smallesPrimeFactor(max);
        int cnt[] = new int[max];

        for(int x : nums) cnt[x]++;

        int mult[] = cnt.clone();

        for(int i=2;i<max;i++){
            for(int j= i * 2;j<max;j+=i){
                mult[i] += cnt[j];
            }
        }

        int ans = 0;
        if(cnt[1] > 0){
            ans = 1;
        }

        for(int i=max - 1;i>1;i--){
            if(ans >= i) break;

            int sub[] = getSub(i);

            int c = -cnt[i];

            for(int mask = 1; mask < sub.length;mask++){
                if((Integer.bitCount(mask) & 1)==1){
                    c += mult[sub[mask]];
                }else{
                     c -= mult[sub[mask]];
                }
            }

            if(cnt[i] > 0){
                int cost = c + cnt[i] - 1;
                ans = Math.max(ans, i - cost);
            }else if(i <= maxVal){
                int cost = c > 0 ? c : 1;
                ans = Math.max(ans, i - cost);
            }
        }

        return ans;
    }
}