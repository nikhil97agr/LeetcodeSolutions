package lexicographically_smallest_string_after_reverse_4073;

class Solution {
    public String lexSmallest(String s) {
        String result = s;
        int n = s.length();
        for(int i=1;i<=n;i++){
            String sub = s.substring(0,i);
            StringBuilder sb = new StringBuilder(sub);
            sb.reverse();
            String st = sb.toString() + s.substring(i);;

            if(st.compareTo(result) < 0) result = st;
        }

        for(int i=1;i<=n;i++){
            String sub = s.substring(n-i);
            StringBuilder sb = new StringBuilder(sub);
            sb.reverse();
            String st = s.substring(0, n-i) + sb.toString();
            if(st.compareTo(result) < 0) result = st;
        }

        return result;
    }
}