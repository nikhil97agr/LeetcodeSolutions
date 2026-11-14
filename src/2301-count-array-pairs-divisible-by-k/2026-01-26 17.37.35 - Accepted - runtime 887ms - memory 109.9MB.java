class Solution {
    public long countPairs(int[] nums, int k) {
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int x : nums){
            if(x%k==0){
                cnt++;
            }else{
                list.add(x);
            }
        }
        long ans = (1l * cnt * (cnt-1))/2;
        int n = nums.length;
        for(int x : nums){
            if(x%k==0){
                ans += ( n - cnt);
            }
        }

        Map<Integer, Integer> map=new HashMap<>();
        for(int x : list){
            divisor(map, x, 1);
        }

        for(int x : list){
            int gcd = gcd(x, k);
            divisor(map, x, -1);

            int req = k/gcd;
            ans += map.getOrDefault(req, 0);
        }
        return ans;
    
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }

    private void divisor(Map<Integer, Integer> map, int x, int sum){
        for(int i=1;i<=Math.sqrt(x);i++){
            if(x%i==0){
                map.merge(i, sum, Integer::sum);
                if(x/i!=i)
                map.merge(x/i, sum, Integer::sum);
            }
        }
    }
}