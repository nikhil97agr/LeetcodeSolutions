package count_anagrams_2605;

class Solution {
    public int countAnagrams(String s) {
        String str[] = s.split(" ");
        int maxLen = 0;
        for(String st : str){
            maxLen = Math.max(maxLen, st.length());
        }
        int fact[] = new int[maxLen+1];
        fact[0] = fact[1] = 1;
        for(int i=2;i<=maxLen;i++){
            fact[i] = prod(fact[i-1], i);
        }
        int invFact[] = new int[maxLen+1];
        for(int i=0;i<=maxLen;i++){
            invFact[i] = inverse(fact[i]);
        }

        int ans = 1;

        for(String st : str){
            int cnt[] = getCnt(st);
            ans = prod(ans, fact[st.length()]);
            for(int x : cnt){
                if(x > 1){
                    ans =prod(ans, invFact[x]);
                }
            }
        }

        return ans;
    }

    private int[] getCnt(String s){
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        return cnt;
    }

    private int inverse(int a){
        int mod = (int)1e9 + 7;
        return pow(a, mod - 2);
    }

    private int pow(int a, int b){
        if(a==0) return 0;
        if(b==0) return 1;
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
        long prod = 1l*a*b;

        return (int)(prod%mod);
    }
}