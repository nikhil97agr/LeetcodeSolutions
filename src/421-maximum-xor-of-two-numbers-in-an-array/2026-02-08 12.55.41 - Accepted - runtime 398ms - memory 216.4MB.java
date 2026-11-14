class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxLen = 0;
        int curr = 0, max = 0;
        for(int x : nums){
            maxLen = Math.max(maxLen, Integer.toBinaryString(x).length());
        }

        for(int i=maxLen - 1;i>=0;i--){
            max <<= 1;

            curr = max | 1;

            Set<Integer> set = new HashSet<>();

            for(int x : nums){
                set.add(x >> i);
            }

            for(int y : set){
                if(set.contains(y ^ curr)){
                    max = curr;
                    break;
                }
            }
        }

        return max;
    }
}