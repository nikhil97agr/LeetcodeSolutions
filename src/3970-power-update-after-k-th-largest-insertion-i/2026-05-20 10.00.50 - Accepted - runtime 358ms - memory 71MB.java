class Solution {

    private int mod = 1_000_000_007;
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result =new ArrayList<>();
        for(int x : nums){
            add(list, x);
        }
        for(int q []: queries){
            int val = q[0];
            int k = q[1];
            add(list, val);
            int x = get(list, k);

            p = pow(p, x);
            result.add(p);
        }

        return result;
    }

    private int get(List<Integer> list, int k){
        int last = list.size() - k;
        return list.get(last);
    }

    private void add(List<Integer> list, int val){
        int ind = Collections.binarySearch(list, val);
        if(ind < 0){
            ind = -ind - 1;

        }

        if(list.size() == ind){
            list.add(val);
        }else{
            list.add(ind , val);
        }
    }

    private int pow(int a, int b){
        int ans = 1;
        while(b > 0){
            if(b%2==1){
                ans = prod(ans, a);
            }

            a = prod(a, a);
            b>>=1;
            
        }

        return ans;
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }

    
}