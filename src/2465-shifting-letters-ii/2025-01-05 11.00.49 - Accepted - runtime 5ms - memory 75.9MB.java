class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char result[] = s.toCharArray();
        int prefix[] = new int[s.length()+1];
        
        for(int shift[] : shifts){
            int val = shift[2]==1?1:-1;
            prefix[shift[0]] +=val;
            prefix[shift[1]+1] -= val;
        }
        
        int sum = 0;
        for(int i=0;i<prefix.length-1;i++){
            sum += prefix[i];
            int x = ((result[i]-'a')+sum)%26;
            if(x<0) x += 26;
            result[i] = (char)('a'+x);
        }
        
        return String.valueOf(result);
    }
}