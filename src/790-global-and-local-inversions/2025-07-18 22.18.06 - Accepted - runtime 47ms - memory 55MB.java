class Solution {
    int global = 0;
    public boolean isIdealPermutation(int[] nums) {
        int local = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i] > nums[i+1]) local++;
        }

        calc(0, n-1, nums);

        return global == local;
    }

    private int[] calc(int start, int end, int nums[]){
        if(start == end){
            return new int[]{nums[start]};
        }

        int mid = (end +start)/2;

        int left[] = calc(start, mid, nums);
        int right[] = calc(mid+1, end, nums);

        int merge[] = new int[end - start + 1];
        int n = left.length;
        int m = right.length;
        int i=0;
        int j=0;
        int k =0;
        while( i < n && j < m){
            if(right[j] > left[i]){
                merge[k] = right[j];
                j++;
            }else{
                global += (m-j);
                merge[k] = left[i];
                i++;
            }
            k++;
        }

        while(i<n) merge[k++] = left[i++];

        while(j<m) merge[k++] = right[j++];


        return merge;
    }
}