class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = (n + (k-1))/k;
        String res [] = new String[size];
        int ind = 0;
        for(int i=0;i<n;){
            res[ind] = s.substring(i, Math.min(i+k, n));
            ind++;
            i+=k;
        }

        while(res[size-1].length() < k){
            res[size-1] += fill;
        }
        return res;
    }
}