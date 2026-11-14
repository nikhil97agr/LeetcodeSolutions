class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int cnt[] =new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int c = 0;
        for(int i=0;i<n;i++){
            set.add(s.charAt(i));
            c++;
            cnt[s.charAt(i)-'a']--;
            boolean temp = true;
            for(char ch : set){
                if(cnt[ch-'a'] != 0){
                    temp = false;
                    break;
                }
            }
            if(temp){
                res.add(c);
                c=0;
                set.clear();
            }
        }
        if(!set.isEmpty()){
            res.add(c);
        }
        return res;
    }
}