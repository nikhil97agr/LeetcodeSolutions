class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[] = new int[26];
        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a'] = i;
        }

        for(int i=1;i<words.length;i++){
            String a = words[i-1];
            String b = words[i];
            for(int j=0;j<a.length();j++){
                if(j==b.length()){
                    return false;
                }

                if(map[a.charAt(j)-'a'] < map[b.charAt(j)-'a']){
                    break;
                }

                if(map[a.charAt(j)-'a'] > map[b.charAt(j)-'a']){
                    return false;
                }
            }
        }

        return true;
    }
}