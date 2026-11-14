package lexicographically_smallest_string_after_a_swap_3484;

class Solution {
    public String getSmallestString(String s) {
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length-1;i++){
            int d1 = ch[i] - '0';
            int d2 = ch[i+1] - '0';
            if(d1%2==d2%2 && (d2 < d1)){
                char temp = ch[i];
                ch[i] = ch[i+1];
                ch[i+1] = temp;
                break;
            }
        }
        
        return new String(ch);
    }
}