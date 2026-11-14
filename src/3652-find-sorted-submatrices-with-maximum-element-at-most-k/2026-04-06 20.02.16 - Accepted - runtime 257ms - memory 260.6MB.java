class Solution {
    public long countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        long ans = 0;
        int histogram[] = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[j][i] > k){
                    histogram[j] = 0;
                    
                }else if(i ==0 || grid[j][i-1] < grid[j][i]){
                    histogram[j] = 1;
                }else{
                    histogram[j]++;
                }
            }
            ans += calcArea(histogram, n);
        }

        return ans;
    }

    private long calcArea(int histogram[], int n){
        long ans = 0;
        var stack = new Stack<Node>();

        stack.push(new Node(-1, 0, -1));

        for(int i=0;i<n;i++){
            int currHeight = histogram[i];
            while(stack.peek().height >= currHeight) stack.pop();
            var peek = stack.peek();
            int curr = peek.current + currHeight * (i - peek.ind);
            ans += curr;
            stack.push(new Node(i, curr, currHeight));
        }

        return ans;
    }

    public class Node{
        int ind;
        int current;
        int height;
        public Node(int ind, int current, int height){
            this.ind = ind;
            this.height =height;
            this.current =current;
        }
    }

}

