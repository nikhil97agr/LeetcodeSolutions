class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int row[] = new int[n];
        int col[] = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(mat[i][j], list);
            }
        }

        for(int i=0;i<arr.length;i++){
            int x = arr[i];
            List<Integer> list = map.get(x);

            row[list.get(0)]++;
            col[list.get(1)]++;

            if(row[list.get(0)] == m || col[list.get(1)] == n){
                return i;
            }
        }
        return -1;
    }
}