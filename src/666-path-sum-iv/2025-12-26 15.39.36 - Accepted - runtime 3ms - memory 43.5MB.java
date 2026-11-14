class Solution {
    public int pathSum(int[] nums) {
        int ans = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int x : nums){
            int val = x%10;
            int p = (x/10)%10;
            int d = x/100;
            map.computeIfAbsent(d, y -> new HashMap<>()).put(p, val);
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{1, 1, map.get(1).get(1)});

        while(!que.isEmpty()){
            int next[] = que.poll();
            int d = next[0];
            int p = next[1];
            int sum = next[2];
            int left = 2*p - 1;
            int right = 2*p;
            int nextD = d + 1;
            Integer leftVal = map.getOrDefault(nextD, new HashMap<>()).get(left);
            Integer rightVal = map.getOrDefault(nextD, new HashMap<>()).get(right);

            if(leftVal == null && rightVal == null){
                ans += sum;
                continue;
            }

            if(leftVal != null){
                que.offer(new int[]{nextD, left, sum + leftVal});
            }

            if(rightVal != null){
                que.offer(new int[]{nextD, right, sum + rightVal});
            }


        }

        return ans;
    }
}