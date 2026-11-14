package minimum_operations_to_sort_a_string_4220;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char ch[] =s.toCharArray();

        int cnt[] = new int[26];
        cnt[ch[0]-'a']++;
        boolean isSorted = true;
        for(int i=1;i<n;i++){
            if(ch[i] < ch[i-1]){
                isSorted = false;
            }

            cnt[ch[i]-'a']++;
        }

        if(isSorted) return 0;

        char min = 'z';
        char max = 'a';
        for(char c : ch){
            min = (char)Math.min(min, c);
            max = (char)Math.max(max, c);
        }

        if(n == 2) return -1;

        if(ch[0] == min && ch[n-1] == max) return 1;

        if(min == ch[n-1] && max == ch[0]){
            if(cnt[ch[n-1]-'a'] ==1 && cnt[ch[0]-'a'] == 1){
                return 3;
            }
        }

        if(min == ch[0] || max == ch[n-1]) return 1;
        return 2;


    }
}