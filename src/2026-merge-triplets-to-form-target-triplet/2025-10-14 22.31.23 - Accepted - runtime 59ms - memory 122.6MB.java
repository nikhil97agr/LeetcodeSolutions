class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> ind = new HashSet<>();
        int n = triplets.length;
        for(int i=0;i<n;i++){
            ind.add(i);
        }
        for(int i=0;i<3;i++){
            Set<Integer> temp = new HashSet<>(ind);

            for(int x : ind){
                if(triplets[x][i] > target[i]){
                    temp.remove(x);
                }
            }
            ind = temp;
        }

        boolean found[] = new boolean[3];

        for(int i=0;i<3;i++){
            for(int x : ind){
                if(triplets[x][i] == target[i]){
                    found[i] = true;
                    break;
                }
            }
        }

        return found[0] && found[1] && found[2];
    }
}