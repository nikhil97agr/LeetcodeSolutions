class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        TreeMap<Integer, Integer> min = new TreeMap<>();
        int cnt = 0;
        TreeMap<Integer, Integer> max = new TreeMap<>();


        int n = nums.length;
        int ans[] =new int[n-k+1];
        int ind = 0;
        for(int i=0,j=0;i<n;i++){
            cnt = add(min, max, cnt, x, nums[i]);

            if(i - j + 1 ==k){
                ans[ind] = get(min);
                ind++;
                cnt = remove(min, max, cnt,x, nums[j]);
                j++;
            }
        }

        return ans;
    }

    private int remove(TreeMap<Integer, Integer> min, TreeMap<Integer, Integer> max, int cnt, int x, int val){
        if(min.containsKey(val)){
            cnt--;
            remove(min, val);
            cnt = balance(min, max, cnt, x);
        }else{
            remove(max, val);
        }

        return cnt;
    }


    private int get(TreeMap<Integer, Integer> map){
        return Math.min(0, map.lastKey());
    }
    private int add(TreeMap<Integer, Integer> min, TreeMap<Integer, Integer> max, int cnt, int x, int val){
        add(min, val);
        cnt++;
        cnt = balance(min, max, cnt, x);

        return cnt;
    }

    private int balance(TreeMap<Integer, Integer> min, TreeMap<Integer, Integer> max, int cnt, int x){
        while(cnt < x && !max.isEmpty()){
            int m = max.firstKey();
            remove(max, m);
            add(min, m);
            cnt++;


        }

        while(cnt > x){
            int m = min.lastKey();
            cnt--;
            add(max, m);
            remove(min, m);
        }


        return cnt;
    }

    private void add(Map<Integer, Integer> map, int val){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0){
            map.remove(val);
        }
    }
}