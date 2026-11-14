class Solution {
    public String kthSmallestPath(int[] dest, int k) {
        int pathSize[][] = new int[dest[0] + 1][dest[1] + 1];
        int x = dest[0];
        int y = dest[1];
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(i==0 && j ==0) pathSize[i][j] = 1;
                else if(i==0) pathSize[i][j] = pathSize[i][j-1];
                else if(j==0) pathSize[i][j] = pathSize[i-1][j];
                else pathSize[i][j] = pathSize[i-1][j] + pathSize[i][j-1];
            }
        }

        StringBuilder res = new StringBuilder();
        while(x !=0 && y !=0){
            if(pathSize[x][y-1] >= k){
                res.append("H");
                y--;
            }else{
                res.append("V");
                k -= pathSize[x][y-1];
                x--;

            }
        }

        while(x-->0) res.append("V");
        while(y-- > 0) res.append("H");

        return res.toString();

    }
}