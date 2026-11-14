package maximum_possible_number_by_binary_concatenation_3579;

class Solution {
    public int maxGoodNumber(int[] nums) {
        String a = Integer.toBinaryString(nums[0]);
        String b = Integer.toBinaryString(nums[1]);
        String c = Integer.toBinaryString(nums[2]);

        return max(solve(a,b,c), solve(a,c,b), solve(b,c,a), solve(b,a,c), solve(c,a,b), solve(c,b,a));
    }

    private int max(int...arr){
        int ans = 0;
        for(int x : arr) ans = Math.max(ans, x);
        return ans;
    }

    private int solve(String a, String b, String c){
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        sb.append(c);
        
        return Integer.parseInt(sb.toString(), 2);
    }

}