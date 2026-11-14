import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().primeSubarray(new int[]{9551,41039,4411}, 41466));
    }
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        boolean primes[] = new boolean[50001];

        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for(int i=2;i<=50000;i++){
            if(primes[i]){
                int j = i+i;
                while(j<=50000){
                    primes[j] = false;
                    j+=i;
                }
            }
        }
        int ans = 0;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Integer> que =new ArrayDeque<>();

        int start = 0;
        int end = 0;


        while(end < n){
            int val = nums[end];
            if(primes[val]){
                add(map, val);
            }
            while(!map.isEmpty() && map.lastKey() - map.firstKey() > k){
                remove(map, nums[start]);

                if(que.getFirst() == start){
                    que.pollFirst();
                }
                start++;
            }
            if(primes[nums[end]] && !que.isEmpty()){
                int last = que.getLast();
                ans += (last - start + 1);

            }else if(!primes[nums[end]] && que.size() > 1){
                int last = que.pollLast();
                int last2 = que.getLast();
                que.offer(last);
                ans += (last2 - start + 1);
            }
            if(primes[nums[end]])
                que.offer(end);
            end++;


        }



        return ans;




    }

    private void add(TreeMap<Integer, Integer> map, int val){
        int cnt = map.getOrDefault(val, 0);
        map.put(val, cnt + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val){
        if(!map.containsKey(val)) return;
        int cnt = map.get(val);
        if(cnt == 1) map.remove(val);
        else map.put(val, cnt - 1);
    }
}