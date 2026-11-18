package building_boxes_1861;

class Solution {
    public int minimumBoxes(int n) {
        int i=0;
        int boxes = 0;
        while(boxes < n){
            i++;
            boxes += (i * (i+1))/2;
        }
        if(boxes == n) return (i * (i+1))/2;

        int ans = ( i * (i-1))/2;
        boxes -= (i * (i+1))/2;

        int j = 0;
        while(boxes < n){
            j++;
            boxes += j;
        }

        return ans + j;
    }
}