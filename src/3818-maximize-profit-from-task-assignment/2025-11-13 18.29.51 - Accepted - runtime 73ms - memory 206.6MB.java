class Solution {
    public long maxProfit(int[] workers, int[][] tasks) {
        long ans=0;
        Map<Integer, Integer> skill = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> profit =new HashMap<>();

        for(int s: workers){
            skill.merge(s,1,Integer::sum);
        }

        for(int t[] : tasks){
            profit.computeIfAbsent(t[0], x -> new PriorityQueue<>(Collections.reverseOrder())).add(t[1]);
        }

        for(int s : profit.keySet()){
            PriorityQueue<Integer> value = profit.get(s);
            int cnt = skill.getOrDefault(s, 0);

            while(cnt > 0 && !value.isEmpty()){
                ans += value.poll();
                cnt--;
            }
        }

        int max= 0;
        for(PriorityQueue<Integer> value : profit.values()){
            if(!value.isEmpty()){
                max = Math.max(value.peek(), max);
            }
        }

        return ans + max;

        
    }
}