package find_kth_character_in_expanded_string_4113;

class Solution {
    public char kthCharacter(String s, long k) {
        long cnt = 0;
        for(String st : s.split(" ")){
            for(int i=0;i<st.length();i++){
                long next = i+1;
                if(cnt + next > k) return st.charAt(i);
                cnt+=next;
            }

            if(cnt == k) return ' ';
            cnt++;
        }

        return ' ';
    }
}