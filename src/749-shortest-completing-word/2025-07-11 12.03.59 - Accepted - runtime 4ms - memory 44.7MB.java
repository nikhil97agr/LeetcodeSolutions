class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String res = null;
        int par[] = getCnt(licensePlate);
        for(String s : words){
            int cnt[] = getCnt(s);

            boolean flag = true;
            for(int i=0;i<26;i++){
                if(cnt[i] < par[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(res == null || res.length() > s.length()){
                    res = s;
                }
            }


        }
        return res == null ? "" : res;
    }

    private int[] getCnt(String s){
        int cnt[] = new int[26];

        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }

        return cnt;
    }
}