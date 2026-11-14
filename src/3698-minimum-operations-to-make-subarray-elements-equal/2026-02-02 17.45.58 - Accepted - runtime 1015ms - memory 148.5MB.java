class Solution {
    long s1 = 0;
    long s2 = 0;
    long c1 = 0;
    long c2 = 0;
    TreeMap<Integer, Integer> min = new TreeMap<>();
    TreeMap<Integer, Integer> max = new TreeMap<>();
    public long minOperations(int[] nums, int k) {
        long ans= Long.MAX_VALUE;
        int n = nums.length;
        for(int i=0,j=0;i<n;i++){
            add(nums[i]);
            if(i - j + 1 == k){
                ans = Math.min(ans, calculate());
                remove(nums[j++]);
            }
        }

        return ans;
    }

    private long calculate(){
        long mod = (c1 + c2)%2;
        int val = -1;
        if(mod ==0){
            val = (min.firstKey() + max.lastKey())/2;
        }else{
             val = min.firstKey();
        }

        return (c2 - c1)*val + s1 - s2;
    }

    private void add(int x){
        add(x, max);
        s2 += x;
        c2++;
        int val = max.lastKey();
        remove(val, max);
        s2 -= val;
        c2--;
        add(val, min);
        s1 += val;
        c1++;
        balance();
    }

    private void add(int val, TreeMap<Integer, Integer> map){
        map.merge(val, 1, Integer::sum);
    }
    private void remove(int val){

        if(min.containsKey(val)){
            c1--;
            s1 -= val;
            remove(val, min);
        }else{
            c2--;
            s2 -= val;
            remove(val, max);
        }
        balance();

    }
    private void remove(int val, TreeMap<Integer, Integer> map){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }



    private void balance(){
        while(c1 - c2 > 1){
            int val = min.firstKey();
            s1 -= val;
            c1--;
            c2++;
            s2 += val;
            remove(val, min);
            add(val, max);
        }
    }
}