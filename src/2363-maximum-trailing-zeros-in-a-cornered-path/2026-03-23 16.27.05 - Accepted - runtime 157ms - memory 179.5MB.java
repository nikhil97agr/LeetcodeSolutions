import java.util.Arrays;

class Solution {

    public int maxTrailingZeros(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        Node hCnt[][] = new Node[n][m + 1];
        Node vCnt[][] = new Node[n + 1][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<=m;j++){
                hCnt[i][j] = new Node(0,0);
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<m;j++){
                vCnt[i][j] = new Node(0, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node cnt = getCnt(grid[i][j]);

                hCnt[i][j + 1] = new Node(cnt);
                vCnt[i + 1][j] = new Node(cnt);
                hCnt[i][j + 1].add(hCnt[i][j]);
                vCnt[i + 1][j].add(vCnt[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Node v1 = vCnt[i + 1][j];
                Node h1 = hCnt[i][j + 1];
                Node v2 = vCnt[n][j].sub(vCnt[i][j]);
                Node h2 = hCnt[i][m].sub(hCnt[i][j]);
                Node sub = vCnt[i+1][j].sub(vCnt[i][j]);
                ans = max(
                        ans,
                        Math.min(v1.two + h1.two - sub.two, v1.five + h1.five - sub.five),
                        Math.min(v1.two + h2.two - sub.two, v1.five + h2.five - sub.five),
                        Math.min(v2.two + h1.two - sub.two, v2.five + h1.five - sub.five),
                        Math.min(v2.two + h2.two - sub.two, v2.five + h2.five - sub.five)
                );
            }
        }

        return ans;
    }

    private int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }

    private Node getCnt(int a) {

        int two = 0;
        int five = 0;
        while (a % 2 == 0) {
            two++;
            a /= 2;
        }

        while (a % 5 == 0) {
            a /= 5;
            five++;
        }

        return new Node(two, five);
    }

    class Node {

        int two;
        int five;

        public Node(Node node) {

            this.two = node.two;
            this.five = node.five;
        }

        public Node(int two, int five) {

            this.two = two;
            this.five = five;
        }
        
        public Node sub(Node node){
            return new Node(
                    two - node.two,
                    five - node.five
            );
        }

        public void add(Node node) {
            two += node.two;
            five += node.five;
        }
    }
}