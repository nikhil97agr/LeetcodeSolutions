package sum_of_digits_of_string_after_convert_2076;

class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            int x = (c-'a')+1;
            sb.append(x);
        }
        s = sb.toString();
        while(k-- > 0){
            int sum = 0;
            for(char c : s.toCharArray()){
                sum += (c-'0');
            }
            s = ""+sum;
            if(s.length()==1) break;
        }

        return Integer.parseInt(s);
    }
}