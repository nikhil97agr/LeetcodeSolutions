class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> dp = new HashMap<>();

        return is(s1, s2, dp);
    }

    private boolean is(String s1, String s2, Map<String, Boolean> dp){

        int n = s1.length();

        if(s2.length()!=n){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        if(n==1){
            return false;
        }

        int cnt[] = new int[26];

        String key = s1+" "+s2;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        for(int i=0;i<n;i++){
            cnt[s1.charAt(i)-'a']++;
            cnt[s2.charAt(i)-'a']--;

        }

        for(int i=0;i<26;i++){
            if(cnt[i]!=0){
                dp.put(key, false);
                return false;
            }
        }

        for(int i=1;i<n;i++){
            if(is(s1.substring(0,i), s2.substring(0,i), dp) && is(s1.substring(i), s2.substring(i), dp)){
                dp.put(key, true);
                return true;
            }

            if(is(s1.substring(0,i), s2.substring(n-i), dp) && is(s1.substring(i), s2.substring(0,n-i), dp)){
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;



    }
}