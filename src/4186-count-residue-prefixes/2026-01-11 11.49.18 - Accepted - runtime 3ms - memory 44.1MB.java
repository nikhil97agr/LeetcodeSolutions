class Solution {
    public int residuePrefixes(String s) {
        int ans = 0;
        int n = s.length();
            int len = 0;
            Set<Character> set = new HashSet<>();
            for(int j=0;j<n;j++){
                set.add(s.charAt(j));
                len++;
                if(set.size() == len%3){
                    ans++;
                }
            }
        return ans;
    }
}