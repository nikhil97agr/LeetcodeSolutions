package split_concatenated_strings_555;

class Solution {
    public String splitLoopedString(String[] strs) {
        int n = strs.length;
        char max = 'a';
        for(int i=0;i<n;i++){
            String s = strs[i];
            for(char c : s.toCharArray()){
                max = (char)Math.max(max, c);
            }
            String rev = reverse(s);
            if(rev.compareTo(s) > 0) strs[i] = rev;
        }
        String result = "";
        for(int i=0;i<n;i++){
            String curr = strs[i];
            String reverse = reverse(strs[i]);

            for(String s : new String[]{curr, reverse}){
                for(int j=0;j<s.length();j++){
                    if(s.charAt(j) == max){
                        StringBuilder sb = new StringBuilder(s.substring(j));
                        int cnt = 0;
                        int start =( i + 1)%n;
                        while(cnt < n-1){
                            sb.append(strs[start]);
                            start++;
                            start%=n;
                            cnt++;
                        }
                        sb.append(s.substring(0, j));

                        String ans = sb.toString();
                        if(ans.compareTo(result) > 0) result = ans;
                    }
                }
            }

        }
        return result;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}