class Solution {
    public int minAnagramLength(String s) {
        int n= s.length();
        for(int i=1;i<s.length();i++){
            if(n%i==0 && check(s.toCharArray(),i)){
                return i;
            }
        }

        return s.length();
    }

    private boolean check(char ch[], int len){
        int n =ch.length;
        int cnt[] = new int[26];

        for(int i=0;i<len;i++){
            cnt[ch[i]-'a']++;
        }

        for(int i=len;i<n;i+=len){
            int c2[] = new int[26];
            for(int j=i;j<i+len;j++){
                c2[ch[j]-'a']++;
            }

            for(int j=0;j<26;j++){
                if(c2[j] != cnt[j]) return false;
            }
        }

        return true;
    }

}