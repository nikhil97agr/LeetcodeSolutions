package find_the_key_of_the_numbers_3568;

class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String n1 = ""+num1, n2=""+num2, n3=""+num3;

        while(n1.length() <4) n1 = "0"+n1;
        while(n2.length() <4) n2 = "0"+n2;
        while(n3.length() <4) n3 = "0"+n3;
        int ans = 0;

        for(int i=0;i<4;i++){
            int c = Math.min(n1.charAt(i)-'0', Math.min(n2.charAt(i)-'0', n3.charAt(i)-'0'));
            ans = ans*10 + c;
        }
        return ans;
    }
}