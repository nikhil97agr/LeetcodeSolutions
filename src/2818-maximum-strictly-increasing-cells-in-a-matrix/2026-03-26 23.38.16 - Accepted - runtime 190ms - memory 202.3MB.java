class Solution {
    public int maxIncreasingCells(int[][] mat) {
        var n = mat.length;
        var m = mat[0].length;
        var map = new TreeMap<Integer, List<int[]>>();
        for(var i=0;i<n;i++){
            for(var j=0;j<m;j++){
                map.computeIfAbsent(mat[i][j], x->new ArrayList<>()).add(new int[]{i, j});
            }
        }

        var row = new int[n];
        var col = new int[m];
        var dp = new int[n][m];

        for(var entry : map.entrySet()){
            for(var pos: entry.getValue()){
                var i = pos[0];
                var j = pos[1];
                dp[i][j] = Math.max(row[i], col[j]) + 1;
            }

            for(var pos : entry.getValue()){
                var i = pos[0];
                var j = pos[1];
                row[i] = Math.max(row[i], dp[i][j]);
                col[j] = Math.max(col[j], dp[i][j]);
            }
        }

        return Math.max(Arrays.stream(row).max().getAsInt(), Arrays.stream(col).max().getAsInt());
    }
}