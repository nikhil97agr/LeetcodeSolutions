package verify_preorder_sequence_in_binary_search_tree_255;

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return solve(preorder, 0, preorder.length-1);
    }

    private boolean solve(int arr[], int start, int end){
        if(start>= end ) return true;

        int curr = arr[start];
        int mid = -1;
        int i=start+1;
        while(i <= end){
            if(arr[i] > curr){
                mid = i;
                break;
            }
            i++;
        }

        if(mid == -1){
            return solve(arr, start+1, end);
        }
        
        i=mid;
        while(i <= end){
            if(arr[i] < curr){
                return false;
            }
            i++;
        }


        return solve(arr, start+1, mid-1) && solve(arr, mid, end);
        
    }


}