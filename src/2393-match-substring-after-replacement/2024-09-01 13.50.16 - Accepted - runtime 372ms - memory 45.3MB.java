class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for(char c[] : mappings){
            map.computeIfAbsent(c[0], c1 -> new HashSet<>()).add(c[1]);
        }

        for(int i=0;i<s.length();i++){
            int j=i;
            int k=0;

            for(; j < s.length() && k < sub.length();j++,k++){
                char ch = s.charAt(j);
                if(sub.charAt(k) ==ch || map.getOrDefault(sub.charAt(k), new HashSet<>()).contains(ch)){
                    continue;
                }else{
                    break;
                }
            }

            if(k==sub.length()){
                return true;
            }
        }

        return false;
    }
}