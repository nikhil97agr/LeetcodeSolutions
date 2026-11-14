package minimum_number_of_swaps_to_make_the_string_balanced_2095;

class Solution {
    public int minSwaps(String s) {
        int cnt = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c=='['){
                open++;
            }else{
                open = Math.max(open-1, 0);
            }
        }

        return (open+1)/2;
    }
}