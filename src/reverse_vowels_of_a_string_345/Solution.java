package reverse_vowels_of_a_string_345;

class Solution {
    public String reverseVowels(String s) {
        boolean vowels[] = new boolean[255];
vowels['a'] = true;
vowels['e'] = true;
vowels['i'] = true;
vowels['o'] = true;
vowels['u'] = true;
vowels['A'] = true;
vowels['E'] = true;
vowels['I'] = true;
vowels['O'] = true;
vowels['U'] = true;
        char ch[] = s.toCharArray();
        int n = ch.length;
        int last = n-1;
        int i =0;
        while(i<last){
            while(!vowels[ch[i]]&&i<last)i++;
            while(!vowels[ch[last]]&&i<last)last--;
            if(i>=last)break;
            char c = ch[i];
            ch[i] = ch[last];
            ch[last] = c;
            i++;
            last--;
        }

        return new String(ch);
    }
}