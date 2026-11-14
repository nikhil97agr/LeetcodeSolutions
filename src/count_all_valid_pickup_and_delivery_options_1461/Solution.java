package count_all_valid_pickup_and_delivery_options_1461;

class Solution {
    public int countOrders(int n) {
        long mod = (int) 1e9 + 7;
        long ans = 1;
        for (long i = 2 * n; i > 0; i -= 2) {
            ans = (ans * ((i * (i - 1)) / 2) % mod) % mod;
        }

        return (int) ans;
    }
}