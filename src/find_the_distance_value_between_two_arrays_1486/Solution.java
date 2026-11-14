package find_the_distance_value_between_two_arrays_1486;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for(int x : arr1){
            boolean found = false;

            for(int y : arr2){
                int dist = Math.abs(x-y);

                if(dist <= d){
                    found= true;
                    break;
                }
            }

            if(found) ans++;
        }

        return arr1.length - ans;
    }
}