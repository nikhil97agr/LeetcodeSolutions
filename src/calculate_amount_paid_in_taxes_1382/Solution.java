package calculate_amount_paid_in_taxes_1382;

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int prev = 0;
        return solve(prev, 0, brackets, income);
    }

    private double solve(int prevBracket, int i, int brackets[][], int income){
        if(i >= brackets.length) return 0;
        int upper = brackets[i][0];
        int perc = brackets[i][1];
        if(income <= upper){
            int left = income - prevBracket;
            double res = (1d*left*perc)/100d;
            return res;
        }

        int left = upper - prevBracket;
        double tax = (1d*left*perc)/100d;

        return tax + solve(upper, i+1, brackets, income);
    }
}