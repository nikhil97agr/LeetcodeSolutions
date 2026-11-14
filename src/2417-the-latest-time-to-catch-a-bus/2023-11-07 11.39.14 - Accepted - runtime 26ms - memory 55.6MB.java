class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int count = 0;
        int n = buses.length;
        int m = passengers.length;
        int i=0;
        int j=0;
        while(i<n){
            count = 0;
            while(count < capacity && j < m && passengers[j]<= buses[i]){
                count++;
                j++;
            }

            i++;
        }

        if(count < capacity && (j==0 || passengers[j-1] != buses[n-1])){
            return buses[n-1];
        }
        j--;
        while(j>0 && passengers[j]-1 == passengers[j-1]){
            j--;
        }

        return passengers[j]-1;
    }
}