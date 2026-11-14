class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        int start = 0;
        int end = m-1;
        
        if(m%2==0){
            start = 0;
            end = m-1;
        }else{
            start = 0;
            end = m-2;
        }
        
        int i=0;
        while(i< n){
            if(i%2==0){
                for(int j=start;j<m;j+=2){
                    res.add(grid[i][j]);
                }
            }else{
                for(int j=end;j>=0;j-=2){
                    res.add(grid[i][j]);
                }
            }
            i++;
        }
        
        return res;
    }
}