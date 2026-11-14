class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double result = 0d;

        int i=prices.length - 1;
        int j=discounts.length - 1;
        while(i >=0 && j >=0){
            result += disc(prices[i], discounts[j]);
            i--;
            j--;
        }

        while(i >=0 ){
            result += prices[i];
            i--;
        }

        return result;
    }

    private double disc(int p, int d){
        double amt = p * (100 - d);

        return amt / 100;
    }
}