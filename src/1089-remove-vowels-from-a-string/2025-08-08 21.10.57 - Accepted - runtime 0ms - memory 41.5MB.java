class Solution {
    public String removeVowels(String s) {
        Set<Character> set = Set.of('a', 'e', 'i','o','u');

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!set.contains(c)) sb.append(c);
        }
        
        return sb.toString();
    }
}