package number_of_beautiful_pairs_2831;

class Solution {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(check((""+nums[i]).charAt(0)-'0', nums[j]%10)){
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean check(int a, int b){
        return gcd(a, b) == 1;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}