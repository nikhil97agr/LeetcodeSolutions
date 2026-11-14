package longest_happy_prefix_1508;

class Solution {
    public String longestPrefix(String s) {
        char c[] = s.toCharArray();
        int ans = -1;
        int start = 0;
        int end = s.length()-1;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(start < s.length()-1){
            sb.append(c[start]);

            StringBuilder s3 = new StringBuilder().append(c[end]);
            s3.append(sb2);

            if(sb.compareTo(s3) == 0){
                ans = start;
            }
            start++;
            end--;
            sb2 = s3;
        }

        return ans == -1 ? "" : s.substring(0, ans+1);
    }
}