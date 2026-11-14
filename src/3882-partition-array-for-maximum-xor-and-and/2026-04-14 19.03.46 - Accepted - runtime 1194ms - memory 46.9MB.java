import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximizeXorAndXor(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int finalState = (1<<n)-1;
        int max = Integer.MAX_VALUE;
        var totalXor = 0;
        for(var x : nums){
            totalXor ^= x;
        }
        for(int i=0;i<=finalState;i++){
            int and = max;
            var xor = 0;
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                int bit = (i >> j) & 1;
                if(bit == 1){
                    xor ^= nums[j];
                    and &= nums[j];
                }else{
                    list.add(nums[j]);
                }
            }
            xor ^= totalXor;
            var invertedXor = ~xor;
            List<Integer> reduced = new ArrayList<>();
            for(int x : list){
                reduced.add( x & invertedXor);
            }
            if(and == Integer.MAX_VALUE){
                and = 0;
            }

            List<Integer> basis = basis(reduced);
            int maxXor = getMaxXor(basis);
            ans = Math.max(ans, 1l * and + xor + 2 * maxXor);
            
            
        }
        
        return ans;
    }
    
    public List<Integer> basis(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(var x : list){
            for(var y : result){
                x = Math.min(x, x ^ y);
            }

            if(x > 0){
                result.add(x);
            }
        }

        return result;
    }

    private int getMaxXor(List<Integer> list){
        int ans = 0;
        for(var x : list){
            ans = Math.max(ans, ans ^ x);
        }

        return ans;
    }
}