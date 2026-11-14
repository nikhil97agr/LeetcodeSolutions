package final_value_of_variable_after_performing_operations_2137;

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String s : operations){
            if(s.startsWith("+") || s.endsWith("+")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}