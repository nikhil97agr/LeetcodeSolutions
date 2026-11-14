class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(prev != c){
                sb.append(c);
                cnt = 1;
                prev = c;
            }else{
                if(cnt != 2){
                    cnt++;
                    sb.append(prev);
                }
            }
        }

        return sb.toString();
    }
}