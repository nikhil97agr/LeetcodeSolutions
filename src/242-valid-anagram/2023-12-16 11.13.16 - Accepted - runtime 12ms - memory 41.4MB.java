class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Integer cnt[] = new Integer[26];
        Arrays.fill(cnt, 0);
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }

        for(Integer c : cnt) if(c!=0) return false;
        return true;
    }
}