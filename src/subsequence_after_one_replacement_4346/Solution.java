package subsequence_after_one_replacement_4346;

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n= s.length();
        int m = t.length();
        if( n > m) return false;
        if(s.equals(t)) return true;

        int i=0;
        int j=0;
        for(;i<n && j < m;j++){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }

        if( i == n) return true;
        int pre[] = new int[m];
        int suff[] = new int[m];
        int len = 0;
        for(i=0,j=0;i < n && j <m;j++){
            pre[j] = len;
            if(s.charAt(i) == t.charAt(j)){
                len++;
                i++;
            }
        }
        len = 0;
        for(i=n-1,j=m-1;i>=0 && j >=0;j--){
            suff[j] = len;
            if(s.charAt(i) == t.charAt(j)){
                len++;
                i--;
            }
        }

        for( i=0;i<m;i++){
            if(pre[i] + suff[i] + 1 == n){
                return true;
            }
        }

        return false;
    }








}