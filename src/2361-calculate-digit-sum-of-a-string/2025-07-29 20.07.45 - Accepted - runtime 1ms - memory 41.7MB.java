class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k){
            s = solve(s, k);
        }
        return s;
    }

    private String solve(String s, int k){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i+=k){
            String sub = s.substring(i, Math.min(i+k, s.length()));

            int num = 0;
            for(char c : sub.toCharArray()){
                num += (c-'0');
            }

            sb.append(num);
        }

        return sb.toString();
    }
}