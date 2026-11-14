class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n= workers.length;
        int m = bikes.length;
        int ans[] = new int[n];
        boolean visW[] = new boolean[n];
        boolean visB[] = new boolean[m];

        List<Pair> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                list.add(new Pair(dist(workers[i], bikes[j]), i, j));
            }
        }

        Collections.sort(list, (p1, p2)->{
            if(p1.dist == p2.dist){
                if(p1.w == p2.w){
                    return p1.b - p2.b;
                }

                return p1.w - p2.w;
            }

            return p1.dist - p2.dist;
        });

        for(Pair pair : list){
            int i = pair.w;
            int j = pair.b;

            if(visW[i] || visB[j]){
                continue;
            }
            visW[i] = true;
            visB[j] = true;

            ans[i] = j;
        }

        return ans;
    }

    private int dist(int a[], int b[]){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    class Pair{
        int dist;
        int w;
        int b;

        public Pair(int dist, int w, int b){
            this.dist = dist;
            this.w = w;
            this.b =b;
        }
    }


}