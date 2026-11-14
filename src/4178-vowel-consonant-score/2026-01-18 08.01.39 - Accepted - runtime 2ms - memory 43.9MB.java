class Solution {
    public int vowelConsonantScore(String s) {
        Set<Character> vowel = Set.of('a', 'e','i','o','u');
        int v = 0;
        int c = 0;
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                if(vowel.contains(ch)) v++;
                else c++;
            }
    
        }
        if(c==0) return 0;
        return v/c;
    }
    
}