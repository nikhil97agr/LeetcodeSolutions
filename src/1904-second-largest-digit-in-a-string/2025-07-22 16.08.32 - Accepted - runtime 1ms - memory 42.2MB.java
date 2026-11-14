class Solution {
    public int secondHighest(String s) {
        int cnt[] = new int[10];

        for(char c : s.toCharArray()){
            if(c>='0' && c<='9') cnt[c-'0']++;
        }

        boolean found = false;

        for(int i=9;i>=0;i--){
            if(cnt[i] > 0){
                if(found) return i;

                found = true;
            }
        }

        return -1;
    }
}