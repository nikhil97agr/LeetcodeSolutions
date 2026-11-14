package lexicographically_largest_string_after_pair_transformations_4366;

class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        String result[] = new String[n];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            int x = nums[i];

            for(char c = 'z';c>='a' && x > 0;c--){
                int pow = c - 'a';

                int req = (int)Math.pow(2, pow);

                if(req <= x){
                    int cnt = x/ req;
                    sb.append((""+c).repeat(cnt));
                    x -= cnt * req;
                }
                
            }

            result[i] = sb.toString();

            sb.setLength(0);
        }

        return result;
    }
}