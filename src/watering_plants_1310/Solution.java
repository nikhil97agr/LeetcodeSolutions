package watering_plants_1310;

class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int n = plants.length;
        int water = capacity;
        for(int i=0;i<n;i++){
            if(plants[i] <= water){
                ans++;
                water -= plants[i];
            }else{
                water = capacity - plants[i];
                ans += 2*i+1;

            }
        }

        return ans;
    }
}