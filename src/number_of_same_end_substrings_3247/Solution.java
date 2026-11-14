package number_of_same_end_substrings_3247;

class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];

        int n = s.length();

        int cnt[] = new int[26];
        int charCnt[][] =new int[n+1][26];
        for(int i=0;i<n;i++){
            int c = s.charAt(i) - 'a';

            charCnt[i+1] = charCnt[i].clone();
            charCnt[i+1][c]++;
        }

        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            for(int j=0;j<26;j++){
                int right = charCnt[r+1][j];
                int left = charCnt[l][j];
                int total = right -left;

                ans[i] += (total*(total+1))/2;
            }
        }
        return ans;
    }
}