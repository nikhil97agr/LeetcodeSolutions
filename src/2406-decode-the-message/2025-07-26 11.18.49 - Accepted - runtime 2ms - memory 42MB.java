class Solution {
    public String decodeMessage(String key, String message) {
        char map[] = new char[26];
        char next = 'a';
        boolean vis[] = new boolean[26];
        for(char c : key.toCharArray()){
            if(c!= ' ' && !vis[c-'a']){
                map[c-'a'] = next;
                vis[c-'a'] = true;
                next++;
            }
        }

        StringBuilder sb  = new StringBuilder();

        for(char c : message.toCharArray()){
            if(c==' ') sb.append(c);
            else{
                sb.append(map[c-'a']);
            }
        }

        return sb.toString();
    }
}