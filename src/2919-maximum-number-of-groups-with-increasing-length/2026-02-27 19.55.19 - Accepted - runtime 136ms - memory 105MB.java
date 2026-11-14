class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int cnt = 0;
        long total = 0;
        for(int x : usageLimits){
            total += x;

            if(total >= (1l * (cnt+1) * (cnt+2))/2){
                cnt++;
            }
        }

        return cnt;
    }
}