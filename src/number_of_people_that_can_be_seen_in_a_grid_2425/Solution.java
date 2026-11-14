package number_of_people_that_can_be_seen_in_a_grid_2425;

import java.util.*;
class Solution {
    public int[][] seePeople(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int ans[][] = new int[n][m];
        for(int i=0;i<n;i++){
            row(ans, heights[i], i, m);
        }

        for(int i=0;i<m;i++){
            int temp[] = new int[n];
            for(int j=0;j<n;j++){
                temp[j] = heights[j][i];
            }

            col(ans, temp, i, n);
        }

        return ans;
    }

    private void col(int ans[][], int arr[], int col, int n){
        Stack<Integer> stack =new Stack<>();
        for(int i=n-1;i>=0;i--){
            int cnt = 0;
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                cnt++;
                stack.pop();
            }

            if(!stack.isEmpty()){
                cnt++;
            }

            ans[i][col] += cnt;

            if(stack.isEmpty() || arr[i] != arr[stack.peek()]){
                stack.push(i);
            }
        }
        
    }

    private void row(int ans[][], int arr[], int row, int n){

        Stack<Integer> stack =new Stack<>();
        for(int i=n-1;i>=0;i--){
            int cnt = 0;
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                cnt++;
                stack.pop();
            }

            if(!stack.isEmpty()){
                cnt++;
            }

            ans[row][i] += cnt;

            if(stack.isEmpty() || arr[i] != arr[stack.peek()]){
                stack.push(i);
            }
        }
    }
}