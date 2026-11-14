class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        long d1 = get(firstWord);
        long d2 = get(secondWord);
        long d3 = get(targetWord);

        return d1 + d2 == d3;
    }
    private long get(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int num = c- 'a';
            sb.append(num);
        }


        return Long.parseLong(sb.toString());
    }
}