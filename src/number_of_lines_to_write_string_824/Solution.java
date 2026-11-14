package number_of_lines_to_write_string_824;

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int cnt = 1;
        int sum = 0;
        for(char c : s.toCharArray()){
            int val = widths[c- 'a'];
            if(val + sum > 100){
                cnt++;
                sum = val;
            }else{
                sum+= val;
            }
        }

        return new int[]{cnt, sum};
    }
}