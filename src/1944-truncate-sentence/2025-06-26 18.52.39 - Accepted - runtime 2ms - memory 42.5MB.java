class Solution {
    public String truncateSentence(String s, int k) {
        String str[] = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length && k > 0;i++){
            sb.append(" "+str[i]);
            k--;
        }

        return sb.toString().trim();
    }
}