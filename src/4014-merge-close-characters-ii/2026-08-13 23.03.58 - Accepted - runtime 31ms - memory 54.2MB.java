class Solution {
    public String mergeCharacters(String s, int k) {
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int lastIndex[] = new int[26];
        int deleted[] = new int[n];
        int cnt = 0;
        Arrays.fill(lastIndex, -1);

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int ind = c - 'a';
            deleted[i] = cnt;
            if(lastIndex[ind] == -1){
                lastIndex[ind] = i;
                res.append(c);
                continue;
            }

            int ii = lastIndex[ind];

            int midDel = deleted[i] - deleted[ii];
            if( i - midDel- ii <= k){
                cnt++;
            }else{
                res.append(c);
                lastIndex[ind] = i;
            }


        }

        return res.toString();
    }
}