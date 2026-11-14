package number_of_adjacent_elements_with_the_same_color_2779;

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int ans[] = new int[m];
        int cnt = 0;

        int arr[] = new int[n];
        
        for(int i=0;i<m;i++){
            int ind = queries[i][0];
            int color = queries[i][1];

            if(ind > 0){
                if(arr[ind-1] == arr[ind] && arr[ind] !=0) cnt--;
            
            }
            if(ind < n-1){
                if(arr[ind+1] == arr[ind] && arr[ind] !=0 ){
                    cnt--;
                }
            }

            arr[ind] = color;

            if(ind > 0 && arr[ind-1] == arr[ind]){
                cnt++;
            }

            if(ind < n-1 && arr[ind+1] == arr[ind]){
                cnt++;
            }
            ans[i] = cnt;
        }

        return ans;

    }
}