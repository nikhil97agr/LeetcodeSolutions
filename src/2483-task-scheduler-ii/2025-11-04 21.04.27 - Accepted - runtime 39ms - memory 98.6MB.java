class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long day = 1;

        Map<Integer, Long> map = new HashMap<>();
        for(int x : tasks){
            long val = map.getOrDefault(x, 0l);
            day = Math.max(day, val);
            map.put(x, day + space + 1);
            day++;
        }
        



        return day-1;
    }
}