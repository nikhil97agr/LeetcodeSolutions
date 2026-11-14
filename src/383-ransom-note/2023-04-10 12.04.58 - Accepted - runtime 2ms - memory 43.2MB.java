class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int cnt1[] = new int[26];
        int cnt2[] = new int[26];
        for(char c : ransomNote.toCharArray()){
            cnt1[c-'a']++;
        }

        for(char c : magazine.toCharArray()){
            cnt2[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(cnt1[i]>cnt2[i]){
                return false;
            }
        }

        return true;

    }
}