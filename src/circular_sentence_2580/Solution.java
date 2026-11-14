package circular_sentence_2580;

class Solution {
    public boolean isCircularSentence(String sentence) {
        String s[] = sentence.split(" ");
        if(s.length==1){
            String str = s[0];
            int n = str.length();
            return str.charAt(0)==str.charAt(n-1);
        }
        
        for(int i=1;i<s.length;i++){
            String s1 = s[i-1];
            String s2 = s[i];
            int n = s1.length();
            if(s1.charAt(n-1)!=s2.charAt(0)){
                return false;
            }
        }
        String last = s[s.length-1];
        return s[0].charAt(0) == last.charAt(last.length()-1);
         
        
    }
}