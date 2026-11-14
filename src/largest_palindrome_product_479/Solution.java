package largest_palindrome_product_479;

class Solution {
    public int largestPalindrome(int n) {
        int largest = (int)Math.pow(10, n) -1;
        int smallest = (int)Math.pow(10, n-1);
        if(n==1) return 9;
        for(int a = largest;a >= smallest;a--){
            long pal = getPal(a);

            for(long i=largest;i *i >= pal;i--){
                if(pal%i==0){
                    long j = pal/i;
                    if(j >= smallest && j <= largest){
                       return (int)(pal%1337);
                    }
                }
            }
        }
        return -1;

    }

    private long getPal(int a){
        StringBuilder sb = new StringBuilder(""+a);
        sb.reverse();

        return Long.parseLong(""+a+sb.toString());
    }
}