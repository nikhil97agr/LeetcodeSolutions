class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int i=0;
        int j=0;
        int k=0;
        while(i < arr1.length && j < arr2.length && k < arr3.length){
            int max = Math.max(arr1[i], Math.max(arr2[j], arr3[k]));

            if(max == arr1[i] && max == arr2[j] && max == arr3[k]){
                result.add(max);
                i++;
                j++;
                k++;
                continue;
            }

            if(arr1[i] !=max) i++;
            if(arr2[j]!=max) j++;
            if(arr3[k] != max) k++;
        }

        return result;
    }
}