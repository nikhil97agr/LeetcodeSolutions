import java.util.Arrays;

class Solution {

    public int minMaxWaitingTime(int[] demand, int[] fuel) {

        int n = demand.length;

        int maxDemand = Arrays.stream(demand).max().getAsInt();

        Map<Integer, List<Integer>> dp = new HashMap<>();
        List<Integer> result = check(demand, fuel[0], fuel[1], 0, 0, 0, n, dp);

        if (result.get(0) == 0)
            return -1;

        return result.get(1);
    }

    private List<Integer> check(int demand[], int f1, int f2, int i, int waitTime1, int waitTime2, int n,
            Map<Integer, List<Integer>> dp) {

        if (i == n) {
            return List.of(0, 0);
        }
        int key = key(f1, f2, i, waitTime1, waitTime2);
        if(dp.containsKey(key)) return dp.get(key);
        if (demand[i] > Math.max(f1, f2)) {
            return List.of(0, 0);
        }

        int maxCar = 0;
        int maxTime = Integer.MAX_VALUE;
        if (demand[i] <= f1) {
            List<Integer> list = check(demand, f1 - demand[i], f2, i + 1, demand[i], Math.max(0, waitTime2 - waitTime1),
                    n, dp);
            int newCars = list.get(0) + 1;
            int newTime = Math.max(list.get(1), waitTime1);
            if (newCars > maxCar) {
                maxCar = newCars;
                maxTime = newTime;
            } else if (maxCar == newCars && newTime < maxTime) {
                maxTime = newTime;
            }

        }

        if (demand[i] <= f2) {
            List<Integer> list = check(demand, f1, f2 - demand[i], i + 1, Math.max(0, waitTime1 - waitTime2), demand[i],
                    n, dp);
            int newCars = list.get(0) + 1;
            int newTime = Math.max(list.get(1), waitTime2);
            if (newCars > maxCar) {
                maxCar = newCars;
                maxTime = newTime;
            } else if (maxCar == newCars && newTime < maxTime) {
                maxTime = newTime;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(maxCar);
        list.add(maxTime);
        dp.put(key, list);
        return list;
    }

    private int key(int f1, int f2, int i,  int wait1, int wait2){
        int a= f1 * 51 + f2;
        int b = a * 51 + i;
        int c = b * 51 + wait1;
        int d = c * 21 + wait2;

        return d;
    }
}