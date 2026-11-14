class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String start[] = startTime.split(":");
        String end[] = endTime.split(":");

        long startSec = get(start);
        long endSec = get(end);

        return (int)(endSec - startSec);
    }

    private long get(String time[]){
        long second = Long.valueOf(time[2]) + 60l * Long.valueOf(time[1]) + 3600 * Long.valueOf(time[0]);
        return second;
    }
}