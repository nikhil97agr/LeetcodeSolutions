package maximum_difference_by_remapping_a_digit_2704;

class Solution {
    public int minMaxDifference(int num) {
        String s = ""+num;
        char ch1[] = s.toCharArray();
        char ch2[] = s.toCharArray();
        int n = s.length();
        char c = ' ';
        for(int i=0;i<n;i++){
            if(ch1[i]!='0' && c==' '){
                c = ch1[i];
                ch1[i] = '0';
                continue;
            }
            if(ch1[i]==c){
                ch1[i] = '0';
            }
        }
        c=' ';
        
        for(int i=0;i<n;i++){
            if(ch2[i]!='9' && c==' '){
                c = ch2[i];
                ch2[i] = '9';
                continue;
            }
            if(ch2[i]==c){
                ch2[i] = '9';
            }
        }
        
        int n1 = Integer.parseInt(new String(ch1));
        int n2 = Integer.parseInt(new String(ch2));
        
        return Math.abs(n1-n2);
        
    }
}