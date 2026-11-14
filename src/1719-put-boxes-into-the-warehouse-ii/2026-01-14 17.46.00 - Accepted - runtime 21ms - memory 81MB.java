class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int n = boxes.length;
        int m = warehouse.length;
        int start = 0;
        int end = m-1;
        int ans = 0;
        int ind =n-1;
        while(start <= end && ind >= 0){
            if(boxes[ind]<= warehouse[start]){
                ans++;
                start++;
            }else if(boxes[ind] <= warehouse[end]){
                ans++;
                end--;
            }

            ind--;
        }

        return ans;
    }
}