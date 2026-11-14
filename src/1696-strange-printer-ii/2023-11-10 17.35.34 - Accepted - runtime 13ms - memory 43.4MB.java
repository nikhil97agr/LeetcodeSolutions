class Solution {

    public boolean isPrintable(int[][] target) {
        Map<Integer, int[]> map = new LinkedHashMap<>();
        int m = target.length;
        int n = target[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map.putIfAbsent(target[i][j], new int[]{i, i, j , j});
                int border[] = map.get(target[i][j]);
                
                border[0] = Math.min(i, border[0]);
                border[1] = Math.max(i, border[1]);
                border[2] = Math.min(j, border[2]);
                border[3] = Math.max(j, border[3]);
            }
        }


        Set<Integer> visited = new HashSet<>();
        Set<Integer> recu = new HashSet<>();
        for(int color : map.keySet()){
            if(!visited.contains(color) && !dfs(color, visited, recu, map, target)) return false;
        }

        return true;
        
    }

    private boolean dfs(int color, Set<Integer> visited, Set<Integer> rec, Map<Integer, int[]> map, int[][] target){

        if(rec.contains(color)) return false;

        rec.add(color);

        int border[] = map.get(color);

        int i = border[0];
        int n = border[1];
        int j = border[2];
        int m = border[3];
        for(;i<=n;i++){
            j=border[2];
            for(;j<=m;j++){
                if(target[i][j]!=color && rec.contains(target[i][j])) return false;
                if(target[i][j] !=color && !visited.contains(target[i][j])){
                    if(!dfs(target[i][j], visited, rec, map, target)) return false;
                }
            }
        }
        visited.add(color);



        rec.remove(color);
        return true;

    }
}