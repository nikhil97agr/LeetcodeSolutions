class Solution {
    public String betterCompression(String s) {
        int cnt[] = new int[26];
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            i++;
            int num = 0;
            while(i <n && Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            cnt[ch-'a']+=num;
            i--;
        }

        StringBuilder res = new StringBuilder();
        for(char ch = 'a';ch<='z';ch++){
            if(cnt[ch-'a']!=0){
                res.append(ch).append(cnt[ch-'a']);
            }
        }
        return res.toString();
    }
}