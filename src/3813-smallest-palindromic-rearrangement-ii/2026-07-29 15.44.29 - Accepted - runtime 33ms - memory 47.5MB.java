class Solution {
    int fact[];
    public String smallestPalindrome(String s, int k) {
        int cnt[] = new int[26];
        int n = s.length();
        int odd = 0;
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
            if(cnt[c-'a']%2==0){
                odd--;
            }else{
                odd++;
            }
        }
        fact = new int[n+1];
        Arrays.fill(fact, Integer.MAX_VALUE);
        fact[0] = fact[1] = 1;
        for(int i=2;i<=n;i++){
            if(fact[i-1] * i  > k){
                break;
            }else{
                fact[i] = fact[i-1] * i;
            }
        }
        boolean isOdd = n%2==1;
        StringBuilder sb = new StringBuilder();
        int i=0;
        int half = n/ 2;
        while( i < half){
            boolean added= false;
            for(char c = 'a';c<='z';c++){
                if(cnt[c-'a'] <=  1) continue;
                cnt[c-'a'] -=2;
                long ways = countWays(cnt, k);
                
                if(ways < k){
                    k-= (int)ways;
                    cnt[c-'a']+=2;
                }else{
                    sb.append(c);
                    added = true;
                    break;
                }

            }


            if(!added) return "";
            i++;
        }

        StringBuilder rev = new StringBuilder(sb.toString());
        if(n%2==1){
            for(char c = 'a';c<='z';c++){
                if(cnt[c-'a'] ==1){
                    sb.append(c);
                    break;
                }
            }
        }
        return sb.toString() + rev.reverse().toString();
    }

    public long countWays(int cnt[], int k){
        int total = 0;
        int freq[] = new int[26];
        for(int c = 0;c<26;c++){
            freq[c] = cnt[c]/2;
            total += freq[c];
        }

        long res = 1;
        for(int i=0;i<26;i++){
            if(freq[i] ==0) continue;
            res = res * comb(total, freq[i], k);

            if(res >= k) return k;
            total -= freq[i];
        }

        return res;
    }

    private long comb(int n, int r, int k){
        if(r > n) return 0;
         r = Math.min(r, n- r);
        long ans = 1;
        for(int i = 1;i<=r;i++){
            ans *= (n -r + i);
            ans/=i;
            if(ans >=k) return k;
        }

        return ans;
    }
}