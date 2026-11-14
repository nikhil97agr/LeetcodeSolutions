/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int start = 0;
        int end = reader.length() - 1;

        while(start< end){
            int len = (end -start + 1)/2;
            if(reader.compareSub(start, start + len - 1, start + len, start + 2*len - 1)!=1){
                start = start + len;
            }else{
                end = start + len - 1;
            }
        }

        return start;
    }
}