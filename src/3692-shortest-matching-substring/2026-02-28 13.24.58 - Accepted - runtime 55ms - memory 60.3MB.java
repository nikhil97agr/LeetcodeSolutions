class Solution {
    public int shortestMatchingSubstring(String s, String p) {
        int n = s.length();
        int start = p.indexOf("*");
        int end = p.indexOf("*", start + 1);
        String pre = p.substring(0, start);
        String mid = p.substring(start + 1, end);
        String suf = p.substring(end+1);

        int preLps[] = lps((pre+":"+s).toCharArray());
        int midLps[] = lps((mid+":"+s).toCharArray());
        int sufLps[] = lps((suf+":"+s).toCharArray());

        int pLen = pre.length();
        int mLen = mid.length();
        int sLen = suf.length();
        preLps = Arrays.copyOfRange(preLps, pLen+1, preLps.length);
        midLps = Arrays.copyOfRange(midLps, mLen+1, midLps.length);
        sufLps = Arrays.copyOfRange(sufLps, sLen+1, sufLps.length);

        int ans = Integer.MAX_VALUE;
        int i=0,j=0,k=0;

        while(i + mLen + sLen < n){
            while(i < n && preLps[i] != pLen) i++;

            if( i >= n) break;

            while(j < n && ( j < i + mLen || midLps[j] != mLen)){
                j++;
            }

            if(j >= n) break;

            while( k < n && (k < j + sLen || sufLps[k] != sLen)){
                k++;
            }

            if(k >= n) break;

            ans = Math.min(ans, k - i + pLen);
            i++;
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int[] lps(char pattern[]){
        int lps[] = new int[pattern.length];
        int i=1;
        int len =0;
        while(i< pattern.length){
            if(pattern[i] == pattern[len]){
                len++;
                lps[i]= len;
                i++;
            }else{
                if(len > 0){
                    len = lps[len - 1];
                }else{
                    i++;
                }
            }
        }

        return lps;
    }
}