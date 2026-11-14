class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int i=0;
        while(i< n ){
            String temp = s.substring(i, Math.min(n, i+2*k));
            StringBuilder sb = new StringBuilder(temp.substring(0, Math.min(temp.length(), k)));
            res.append(sb.reverse());

            if(temp.length() > k){
                res.append(temp.substring(k));
            }

            i+=2*k;
        }

        return res.toString();
    }
}