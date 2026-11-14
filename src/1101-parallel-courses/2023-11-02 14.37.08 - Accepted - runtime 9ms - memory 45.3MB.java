class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int degree[] =new int[n];
        Set<Integer> set[]= new HashSet[n];
        for(int i=0;i<n;i++){ set[i] = new HashSet<>(); }
        for(int r[] : relations){
            set[r[0]-1].add(r[1]-1);
            degree[r[1]-1]++;
        }
        int sem = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0) que.add(i);
        }

        while(!que.isEmpty()){
            sem++;
            int size = que.size();
            for(int i=0;i<size;i++){
                int x = que.poll();
                for(int y : set[x]){
                    degree[y]--;
                    if(degree[y]==0){
                        que.add(y);
                    }
                }
            }
        }

        for(int x : degree){
            if(x>0) return -1;
        }

        return sem;



    }
}