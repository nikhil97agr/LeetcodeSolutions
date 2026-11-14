package find_the_original_typed_string_ii_3618;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int possibleStringCount(String word, int k) {
        int n = word.length();

        if(n < k) return 0;

        if(n==k) return 1;

        long total =1;
        long cnt =1;

        List<Long> list =new ArrayList<>();

        for(int i=1;i<word.length();i++){
            if(word.charAt(i) == word.charAt(i-1)){
                cnt++;
            }else{
                list.add(cnt-1);
                total = multi(total, cnt);
                cnt = 1;
            }
        }

        list.add(cnt-1);
        total = multi(total, cnt);

        int minLen = list.size();

        if(k <= minLen) return (int)total;

        k -= minLen;

        long dp[] = new long[k];
        dp[0] = 1;

        for(long x : list){
            long pre[] = new long[k];
            pre[0] = dp[0];

            for(int i=1;i<k;i++){
                pre[i] = add(pre[i-1], dp[i]);
            }

            for(int i=0;i<k;i++){
                if(i-(int)x - 1 >=0 )
                dp[i] = add(pre[i] - pre[i-(int)x-1]); 
                else 
                dp[i] = pre[i];
            }
        }
        
        long ans = 0;
        
        for(int i=0;i<k;i++){
            ans = add(ans, dp[i]);
        }

        return (int)add(total - ans);

    }
    private long add(long a){
        long mod = (long)1e9 + 7;

        return (a+mod)%mod;
    }
    private long add(long a, long b){
        long mod = (long)1e9 + 7;

        return (a + b)%mod;
    }

    private long multi(long a, long b){
        long mod = (long)1e9 + 7;

        return (a*b)%mod;
    }
}