class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return solve(0, s, s.length(), 0, pattern.toCharArray(), pattern.length(), new String[26]);
    }

    private boolean solve(int i, String pattern, int n, int j, char s[], int m, String mapping[]){
        if(i==n && j==m) return true;
        if(i==n || j==m) return false;

        char c = s[j];

        if(mapping[c-'a']==null){
            int ind = i;
            while(ind < n){
                String sub = pattern.substring(i, ind + 1);
                boolean found = false;
                for(String st : mapping){
                    if(st !=null && st.equals(sub)){
                        found = true;
                        break;
                    }
                }
                if(found){
                    ind++;
                    continue;
                }
                mapping[c-'a'] = sub;
                if(solve(ind + 1, pattern, n, j+1, s, m, mapping)) return true;
                mapping[c-'a'] = null;
                ind++;
            }
        }else{
            int len = mapping[c-'a'].length();

            if(i + len <= n && pattern.substring(i, i+len).equals(mapping[c-'a'])){
                if(solve(i+len, pattern, n, j+1, s, m, mapping)) return true;
            }
        }

        return false;
    }
}