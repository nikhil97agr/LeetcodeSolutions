class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        int ans = 0;
        
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                upper.add(ch);
            }else{
                char c= Character.toUpperCase(ch);
                if(upper.contains(c) && set.contains(ch)){
                    set.remove(ch);
                }else if(!upper.contains(c)){
                    set.add(ch);
                }
            }
            
        }
        
        for(char ch : set){
            char c = Character.toUpperCase(ch);
            if(upper.contains(c)) ans++;
        }
        return ans;
    }
}