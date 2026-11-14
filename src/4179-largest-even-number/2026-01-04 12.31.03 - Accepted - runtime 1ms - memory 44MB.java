class Solution {
    public String largestEven(String s) {
        int cnt = 0;
        for(int i=s.length()-1;i>=0 && s.charAt(i) =='1';i--){
            cnt++;
        }

        return s.substring(0, s.length()-cnt);
    }
}