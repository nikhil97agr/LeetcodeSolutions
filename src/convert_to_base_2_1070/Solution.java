package convert_to_base_2_1070;

class Solution {
    public String baseNeg2(int n) {
        StringBuilder result = new StringBuilder();

        while( n != 0){
            result.append(n&1);

            n = -(n>>1);


        }

        if(result.length() ==0) return "0";
        return result.reverse().toString();
    }
}