class Solution {
    public String findValidPair(String s) {
        int cnt[] = new int[10];
        for(char c : s.toCharArray()){
            int dig = c-'0';
            cnt[dig]++;
        }
        for(int i=0;i<s.length()-1;i++){
            int dig1 = s.charAt(i)-'0';
            int dig2 = s.charAt(i+1)-'0';
            if(dig1!=dig2 && cnt[dig1] == dig1 && cnt[dig2] == dig2){
                return ""+dig1+dig2;
            }
        }
        return "";
    }
}