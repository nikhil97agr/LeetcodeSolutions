package replace_elements_with_greatest_element_on_right_side_1231;

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = arr[n-1];
        int []result = new int[n];
        result[n-1] = -1;
        for(int i=n-1;i>0;i--){
            max = Math.max(arr[i], max);
            result[i-1] = max;
        }
        return result;
    }
}