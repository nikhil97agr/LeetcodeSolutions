package average_salary_excluding_the_minimum_and_maximum_salary_1584;

class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double total = 0;
        for(int x : salary){
            max= Math.max(max, x);
            min = Math.min(min, x);
            total += x;
        }

        total -= (max+min);

        return total/(1d*(n-2));

        
    }
}