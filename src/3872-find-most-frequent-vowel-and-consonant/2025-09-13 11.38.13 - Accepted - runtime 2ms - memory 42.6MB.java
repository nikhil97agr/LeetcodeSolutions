class Solution {
    public int maxFreqSum(String s) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');


        int c = 0;
        int v = 0;

        for(char ch='a';ch<='z';ch++){
            if(set.contains(ch)) v = Math.max(v, cnt[ch-'a']);
            else c = Math.max(c, cnt[ch-'a']);
        }

        return v+c;
    }
}