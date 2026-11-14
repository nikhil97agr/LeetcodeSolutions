package maximize_sum_of_squares_of_digits_4084;

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder result = new StringBuilder();

        while(sum > 0 && result.length() < num){
            if(sum >= 9){
                result.append(9);
                sum -= 9;
            }else{
                result.append(sum);
                sum -= sum;
            }
        }

        if(result.length() == num){
            if(sum != 0) return "";
            return result.toString();
        }
        while(result.length() < num){
            result.append(0);
        }

        return result.toString();
    }
}