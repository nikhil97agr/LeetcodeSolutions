package sort_an_array_948;

class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        nums = sort(nums,0, n-1);
        return nums;
    }

    private int[] sort(int nums[], int start, int end){
        if(start==end){
            return new int[]{nums[start]};
        }

        int mid = start + (end-start)/2;
        int left[] = sort(nums, start, mid);
        int right[] = sort(nums, mid+1, end);

        return merge(left, right);
    }

    private int[] merge(int []left, int right[]){
        int n = left.length;
        int m = right.length;
        int i =0;
        int j=0;
        int k=0;
        int result[] = new int[n+m];
        while(i<n && j<m){
            if(left[i] < right[j]){
                result[k++] = left[i];
                i++;
            }else{
                result[k++] = right[j];
                j++;
            }
        }

        while(i<n){
            result[k++] = left[i++];
        }

        while(j<m){
            result[k++] = right[j++];
        }
        return result;
    }
}