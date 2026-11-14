class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int start = 1;
        int end = runningCosts.length;
        int ans = 0;
        int n = chargeTimes.length;
        while(start <= end){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            long sum = 0;
            int size = (start + end)/2;

            boolean found= false;

            for(int i=0;i<size-1;i++){
                map.merge(chargeTimes[i], 1, Integer::sum);
                sum += runningCosts[i];
            }

            int s =0;
            int e = size-1;
            while(e < n){
                map.merge(chargeTimes[e], 1, Integer::sum);
                sum += runningCosts[e];

                long cost = sum*size + map.lastKey();

                if(cost <= budget){
                    found =true;
                    break;
                }

                map.merge(chargeTimes[s], -1, Integer::sum);
                if(map.get(chargeTimes[s])==0) map.remove(chargeTimes[s]);
                sum -= runningCosts[s];
                s++;
                e++;

            }

            if(found){
                ans = size;
                start = size + 1;
            }else{
                end = size - 1;
            }

        }
        return ans;
    }
}