class Solution {
    public int firstUniqChar(String s) {
        int cnt[] = new int[255];
        for(char c : s.toCharArray()){
            cnt[c]++;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(cnt[c]==1) return i;
        }

        return -1;
    }
}