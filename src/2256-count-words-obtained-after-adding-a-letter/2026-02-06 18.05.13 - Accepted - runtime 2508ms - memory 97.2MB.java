class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Map<String, Integer> map =new HashMap<>();
        for(String s : targetWords){
            String st = anagram(s);
            map.merge(st, 1, Integer::sum);
        }
        int ans = 0;
        Set<String> words = new HashSet<>();
        for(String s : startWords) words.add(s);
        for(String s : words){
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                set.add(c);
            }
            for(char c ='a';c<='z';c++){
                if(set.contains(c)) continue;
                String st = anagram(s + c);
                if(!map.containsKey(st)) continue;
                ans += map.get(st);
                map.remove(st);
            }
        }

        return ans;
    }
    private String anagram(String s){
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int c : cnt){
            sb.append(c+":");
        }

        return sb.toString();
    }
}