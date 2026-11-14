class Solution {
    public long distributeCandies(int n, int limit) {
       int notAllowed = limit + 1;
       /**
         * Here formula is calculated using stars & bars method where stars are candies and bars are number of children - 1 which act as divider to split the stars (** | ** | **)
         * So the formula basically calculates number of ways to place 2 bars, that's why we are calculating C(n+2, 2)
         * now after that we are using inclusion-exclusion formula to calculate number of combinations where 1 child is having over limit, 2 children having over limit and all three of them has over limit.
       
        */
       return calc(n+2) - calc(n-notAllowed+2)*3 + calc(n-2*notAllowed+2)*3 - calc(n - 3 * notAllowed+2);
    }

    private long calc(int n){
        if(n < 0) return 0;

        return (1l*n*(n-1))/2;
    }


}