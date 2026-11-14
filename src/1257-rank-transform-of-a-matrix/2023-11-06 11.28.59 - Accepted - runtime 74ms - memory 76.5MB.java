class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        List<Cell> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(new Cell(i, j, matrix[i][j]));
            }
        }

        Collections.sort(list);

        List<Cell> temp = new ArrayList<>();
        int last = Integer.MIN_VALUE;

        for(Cell c : list){
            if(c.val != last){
                solve(temp, matrix, row, col, n, m);
                last = c.val;
                temp.clear();
            }

            temp.add(c);
        }

        solve(temp, matrix, row, col, n,m);
        return matrix;
    }

    private void solve(List<Cell> list, int [][]mat, int row[], int col[], int n, int m){
        int parent[] = new int[n+m];
        if(list.isEmpty()) return ;

        Arrays.fill(parent, -1);
        for(Cell cell : list){
            int x = cell.x;
            int y = cell.y;

            int p1 = find(x, parent);
            int p2 = find(y+n, parent);

            if(p1 != p2){
                int rank = Math.min(parent[p1], Math.min(parent[p2], -Math.max(row[x], col[y])-1));
                parent[p1] = p2;
                parent[p2] = rank;

            }
        }
        for(Cell c : list){
            int rank = -parent[find(c.x, parent)];
            mat[c.x][c.y] = rank;
            row[c.x] = rank;
            col[c.y] = rank;
        }
    }

    private int find(int i, int parent[]){
        if(parent[i] < 0) return i;

        return parent[i] = find(parent[i], parent);
    }
}




class Cell implements Comparable<Cell>{
    int x;
    int y;
    int val;

    public Cell(int x, int y, int val){
        this.x =x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Cell cell){
        return this.val - cell.val;
    }
}