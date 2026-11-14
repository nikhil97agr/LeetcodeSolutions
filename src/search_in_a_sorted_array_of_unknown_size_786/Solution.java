package search_in_a_sorted_array_of_unknown_size_786;

// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
interface ArrayReader {
    public int get(int index);
}

class Solution {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 10001;
        while(start <= end){
            int mid = (start + end)/2;
            int val = reader.get(mid);
            if(val == Integer.MAX_VALUE){
                end = mid - 1;
            }else{
                if(val < target){
                    start = mid + 1;
                }else if(val > target){
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
        }

        return -1;
    }
}