class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long total = Arrays.stream(damage).mapToLong(x -> x).sum();

        long ans = total;

        for(int x : damage){
            ans = Math.min(ans, total - Math.min(armor, x));
        }

        return ans+1;
    }
}