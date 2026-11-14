class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int mat[][] = new int[k][k];

        List<Integer> row = topoSort(rowConditions,  k);
        List<Integer> col = topoSort(colConditions,  k);

        if(row.size()!=k || col.size()!=k) return new int[0][0];

        Map<Integer, Integer> rowMapping = new HashMap<>();
        for(int i=0;i<k;i++){
            rowMapping.put(row.get(i), i);
        }

        int matrix[][] =new int[k][k];

        for(int i=0;i<k;i++){
            matrix[rowMapping.get(col.get(i))][i] = col.get(i);
        }

        return matrix;

    }

    private List<Integer> topoSort(int edge[][], int k){
        

        LinkedList<Integer> adjList[] = new LinkedList[k+1];
        Map<Integer, Integer> degree = new HashMap<>();
        for(int i=1;i<=k;i++){
            adjList[i] = new LinkedList<>();
            degree.put(i, 0);
        }

        for(int e[] : edge){
            adjList[e[0]].add(e[1]);
            degree.put(e[1], degree.get(e[1])+1);
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for(int key : degree.keySet()){
            if(degree.get(key)==0){
                que.add(key);
            }
        }
        while(!que.isEmpty()){
            int node = que.poll();
            res.add(node);
            for(int x : adjList[node]){
                degree.put(x, degree.get(x)-1);
                if(degree.get(x)==0) que.add(x);
            }
        }

        return res;
    }
}