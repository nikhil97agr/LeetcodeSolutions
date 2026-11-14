package faulty_sensor_1980;

class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        int n = sensor1.length;

        int i=0;
        while( i < n && sensor1[i] == sensor2[i]) i++;

        while( i + 1 < n && sensor1[i] == sensor2[i+1] && sensor2[i] == sensor1[i+1]){
            i++;
        }

        if( i >= n-1) return -1;

        if(sensor1[i] == sensor2[i+1]) return 1;
        return 2;
    }
}