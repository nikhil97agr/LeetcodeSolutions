package repeated_string_match_686;

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int lps[]= lps(b.toCharArray());
        int i=0;
        int j =0;
        int n =a.length();
        while(a.length() <= b.length()){
            a += a;
        }

        a+=a;

        while(i < a.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;

                if(j==b.length()){
                    if(i%n==0){
                        return i/n;
                    }
                    return (i+ n-1)/ n;
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }

    private int[] lps(char ch[]){
        int n = ch.length;
        int lps[] = new int[n];
        
        int i=1;
        int len = 0;
        while( i < n){
            if(ch[i]== ch[len]){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len ==0){
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }
}