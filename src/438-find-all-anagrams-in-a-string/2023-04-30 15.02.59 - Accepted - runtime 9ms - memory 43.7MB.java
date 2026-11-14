class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int cs[] = new int[26];
        int cp[] = new int[26];
        if(p.length()>s.length()){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        for(char c : p.toCharArray()){
            cp[c-'a']++;
        }
        for(int i=0;i<m;i++){
            cs[s.charAt(i)-'a']++;
        }
        for(int i=m;i<n;i++){
            if(isValid(cp, cs)){
                result.add(i-m);
            }
            cs[s.charAt(i)-'a']++;
            cs[s.charAt(i-m)-'a']--;
        }
        if(isValid(cp,cs)){
            result.add(n-m);
        }
        return result;
    }

    private boolean isValid(int cp[], int cs[]){
        for(int i=0;i<26;i++){
            if(cs[i]!=cp[i]){
                return false;
            }
        }
        return true;
    }
}