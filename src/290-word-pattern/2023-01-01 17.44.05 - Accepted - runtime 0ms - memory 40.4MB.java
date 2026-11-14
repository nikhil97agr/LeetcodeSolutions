class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");
        String cnt[] = new String[25];
        int i =0;
        Set<String> set =  new HashSet<String>();
        for(char ch : pattern.toCharArray()){
            if(i==str.length){
                return false;
            }
            if(cnt[ch-'a']==null){
                if(set.contains(str[i])){
                    return false;
                }
                set.add(str[i]);
                cnt[ch-'a'] = str[i++];
            }else{
                if(!cnt[ch-'a'].equals(str[i++])){
                    return false;
                }
            }
        }
        if(i!=str.length){
            return false;
        }
        return true;
    }
}