class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int a = capacityA;
        int b = capacityB;

        int i =0;
        int j = plants.length - 1;

        while(i < j){
            if(a < plants[i]){
                ans++;
                a = capacityA;

            }
            a -= plants[i];
            i++;

            if(b < plants[j]){
                ans++;
                b = capacityB;
            }
            b -= plants[j];
            j--;
        }
        if(i==j){
            if(Math.max(a,b) < plants[i]){
                ans++;
            }
        }

        return ans;
    }
}