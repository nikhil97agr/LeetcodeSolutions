package prime_palindrome_897;

class Solution {
    public int primePalindrome(int n) {

        while (true) {
            if (n == rev(n) && prime(n)) {
                return n;
            }

            n++;
            if (n > 10_000_000 && n < 100_000_000) {
                n = 100_000_000;
            }

        }
    }

    private boolean prime(int n) {
        if (n == 1)
            return false;
        if (n <= 3)
            return true;
        if ((n & 1) == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    private int rev(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + (n % 10);
            n /= 10;
        }

        return ans;
    }
}