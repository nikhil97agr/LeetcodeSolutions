package maximum_containers_on_a_ship_3817;

class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int max = n*n;

        return Math.min(max, maxWeight/w);
    }
}