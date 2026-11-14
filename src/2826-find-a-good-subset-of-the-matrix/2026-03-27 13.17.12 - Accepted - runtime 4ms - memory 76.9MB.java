class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = grid.length;
        int n= grid[0].length;
        int max = (1<< n ) - 1;
        for(int i=0;i<m;i++){
            int mask = 0;
            for(int j=0;j<n;j++){
                mask |= (grid[i][j] << j);
            }

            if(mask == 0){
                return Arrays.asList(i);
            }

            if(!map.containsKey(mask)){
                map.put(mask, i);
            }
            int req = max & ~mask;

            for(int j=0;j<=max;j++){
                if( ((req | j) == req)){
                    if(map.containsKey(j)){
                        return Arrays.asList(map.get(j), i);
                    }
                }
            }

        }

        return new ArrayList<>();
    }
}