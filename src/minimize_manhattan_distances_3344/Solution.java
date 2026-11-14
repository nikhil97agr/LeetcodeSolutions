package minimize_manhattan_distances_3344;

class Solution {

    public int minimumDistance(int[][] points) {
        int curr[] = findMaxDistance(points, -1);
        
        return Math.min(findMaxDistance(points, curr[1])[0], findMaxDistance(points, curr[2])[0]);
    }

    private int[] findMaxDistance(int points[][], int skipIndex) {

        int maxAdd[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int maxSub[] = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        int addInd[] = new int[]{0, 0};
        int subInd[] = new int[]{0, 0};

        for (var i = 0; i < points.length; i++) {
            if (i == skipIndex) {
                continue;
            }
            int sum = points[i][0] + points[i][1];
            int diff = points[i][0] - points[i][1];

            if (sum < maxAdd[0]) {
                maxAdd[0] = sum;
                addInd[0] = i;
            }

            if(sum > maxAdd[1]){
                maxAdd[1] = sum;
                addInd[1] = i;

            }

            if (diff < maxSub[0]) {
                maxSub[0] = diff;
                subInd[0] = i;
            }

            if(diff > maxSub[1]){
                maxSub[1] = diff;
                subInd[1] = i;
            }
        }

        if(maxAdd[1] - maxAdd[0] > maxSub[1] - maxSub[0]){
            return new int[]{ maxAdd[1] - maxAdd[0], addInd[0], addInd[1]};
        }
        
        return new int[]{maxSub[1] - maxSub[0], subInd[0], subInd[1]};
    }
}