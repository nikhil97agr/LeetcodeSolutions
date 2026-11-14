package partitioning_into_minimum_number_of_deci_binary_numbers_1807;

class Solution {
    public int minPartitions(String n) {
        char curr  = '0';
        for(char c : n.toCharArray()){
            if(c > curr){
                curr = c;
            }
        }
        return curr-'0';
    }
}