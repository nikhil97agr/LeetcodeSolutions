package minimum_number_of_valid_strings_to_form_target_ii_3557;

class Solution {
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int lps[] = new int[n+1];
        for(String s : words){
            int lp[] = kmp((s+":"+target).toCharArray());
            for(int i=1;i<=n;i++){
                lps[i] = Math.max(lps[i], lp[i + s.length()]);
            }
        }

        int ans = 0;
        int currLen = n;
        while (currLen > 0 && lps[currLen] > 0){
            currLen -= lps[currLen];
            ans++;
        }

        if(currLen ==0) return ans;
        return -1;
    }

    private int[] kmp(char ch[]){
        int n = ch.length;
        int lps[]= new int[n];
        int len = 0;
        int i=1;
        while(i < n){
            if(ch[i] == ch[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if( len ==0){
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }

}