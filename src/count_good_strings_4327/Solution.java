package count_good_strings_4327;

class Solution {
    long mod = (long)1e9 + 7;
    public int countGoodStrings(long n) {
        int ans[][] = new int[][]{{1, 0}, {0, 1}};
        int a[][] = new int[][]{{1, 1}, {1, 0}};
        n--;
        while( n > 0){
            if(n%2==1){
                ans = prod(ans, a);
            }
            a = prod(a, a);
            n/=2;
        }

        return prod(ans[0][0], 2);
    }

    private int prod(int a, int b){
        return (int)((1l * a * b)%mod);
    }

    private int add(int a, int b){
        long s = 1l * a + b;
        return (int)(s%mod);
    }

    private int[][] prod(int a[][], int b[][]){
        return new int[][]{
            {add(prod(a[0][0], b[0][0]), prod(a[0][1], b[1][0])), add(prod(a[0][0], b[0][1]), prod(a[0][1], b[1][1]))},
            {add(prod(a[1][0], b[0][0]), prod(a[1][1], b[1][0])), add(prod(a[1][0], b[0][1]), prod(a[1][1], b[1][1]))}
        };
    }
}