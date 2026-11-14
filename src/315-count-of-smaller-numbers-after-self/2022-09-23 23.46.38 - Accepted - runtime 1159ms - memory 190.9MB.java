class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer result[] = new Integer[n];
        Arrays.fill(result, 0);
        int map[][] = new int[n][2];
        if(nums.length==0){
            return Arrays.asList(result);
        }
        for(int i=0;i<n;i++){
            map[i][0] = nums[i];
            map[i][1] = i;
        }
        mergeSort(map,0, n-1, result);
        return Arrays.asList(result);
    }
    
    public int[][] mergeSort(int[][] map,int start, int end, Integer[] result){
        if(start==end){
            return new int[][]{{map[start][0], map[start][1]}};
        }
        int mid = (start+end)/2;
        int left[][] = mergeSort(map, start, mid, result);
        int right[][] = mergeSort(map, mid+1, end, result);
        
        int ans[][] = merge(left, right, result);

        return ans;
    }
    
    public int[][] merge(int [][]left, int right[][], Integer[] result){
        int n = left.length;
        int m = right.length;
        int i =0;
        int j = 0;
        int ans[][] = new int[n+m][2];
        int k =0;
        while(i<n&&j<m){
            if(left[i][0]<=right[j][0]){
                ans[k][0] = right[j][0];
                    ans[k][1] = right[j][1];
                k++;
                j++;
            }
            else{
                result[left[i][1]] += m-j;
                ans[k][0] = left[i][0];
                ans[k][1] = left[i][1];
                i++;
                k++;
            }
            
        }
        while(i<n){
            ans[k][0] = left[i][0];
            ans[k][1] = left[i][1];
            k++;
            i++;
        }
        while(j<m){
            ans[k][0] = right[j][0];
            ans[k][1] = right[j][1];
            k++;
            j++;
        }
        return ans;
    }
    
    
}