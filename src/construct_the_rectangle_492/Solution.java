package construct_the_rectangle_492;

class Solution {
    public int[] constructRectangle(int area) {
        int ans[] =new int[]{area, 1};
        for(int w =1;w<=Math.sqrt(area);w++){
            if(area%w==0){
                ans = new int[]{area/w, w};
            }
        }
        return ans;
    }
}