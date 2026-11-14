class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int cnt[] = new int[26];
        for(String s : words2){
            int c[] = new int[26];
            for(char ch : s.toCharArray()){
                c[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                cnt[i] = Math.max(cnt[i], c[i]);
            }
        }

        for(String s : words1){
            int c[] = new int[26];
            for(char ch : s.toCharArray()){
                c[ch-'a']++;
            }
            boolean ans = true;
            for(int i=0;i<26;i++){
                if(c[i] < cnt[i]){
                    ans = false;
                    break;
                }
            }

            if(ans)list.add(s);
        }

        return list;
    }
}