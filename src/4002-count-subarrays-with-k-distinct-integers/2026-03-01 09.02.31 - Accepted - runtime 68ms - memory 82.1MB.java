import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        long ans= 0;
        int n = nums.length;
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        int c1 = 0;
        int c2 = 0;
        int l1 = 0;
        int l2 = 0;

        for(int i=0;i<n;i++){
            int val = nums[i];
            add(val, m1);
            if(m1.get(val) == m){
                c1++;
            }

            add(val, m2);
            if(m2.get(val) == m){
                c2++;
            }

            while(m1.size() > k){
                int num = nums[l1];
                if(m1.get(num) == m){
                    c1--;
                }
                remove(num, m1);
                l1++;
            }

            while(m2.size() > k || (m2.size() == k && (m2.get(nums[l2]) > m || c2 > k))){
                int num = nums[l2];
                if(m2.get(num) ==m){
                    c2--;
                }
                remove(num, m2);
                l2++;
                
            }
            
            if(m1.size() == k && c1 == k){
                ans += (l2 - l1 + 1);
            }
        }
        return ans;
    }

    private void add(int val, Map<Integer, Integer> map){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(int val, Map<Integer, Integer> map){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }

}