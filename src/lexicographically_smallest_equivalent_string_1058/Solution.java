package lexicographically_smallest_equivalent_string_1058;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char par[] = new char[26];
        char min[] = new char[26];

        for(char c = 'a'; c<='z'; c++){
            par[c-'a'] = c;
            min[c-'a'] = c;
        }

        for(int i=0;i<s1.length();i++){
            char p1 = find(par, s1.charAt(i));
            char p2 = find(par, s2.charAt(i));

            if(p1 != p2){
                par[p1-'a'] = p2;
            }
        }
        for(char c = 'a'; c<= 'z'; c++){
            char p = find(par, c);

            if(min[p-'a'] > c){
                min[p-'a'] = c;
            }
        }

        StringBuilder res = new StringBuilder();

        for(char c : baseStr.toCharArray()){
            char p = find(par, c);

            res.append(min[p-'a']);
        }

        return res.toString();

    }

    private char find(char par[], char val){
        if(par[val-'a'] == val) return val;

        return par[val-'a'] = find(par, par[val-'a']);
    }
}