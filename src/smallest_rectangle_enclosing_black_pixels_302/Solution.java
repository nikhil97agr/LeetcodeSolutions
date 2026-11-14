package smallest_rectangle_enclosing_black_pixels_302;

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int xmin = Integer.MAX_VALUE;
        int xmax = -1;
        int ymax= -1;
        int ymin = Integer.MAX_VALUE;
        int n =image.length;
        int m = image[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(image[i][j] == '1'){
                    xmin = Math.min(xmin, i);
                    ymin = Math.min(ymin, j);

                    xmax = Math.max(xmax, i);
                    ymax = Math.max(ymax, j);
                }
            }
        }

        return (xmax - xmin + 1) * (ymax - ymin + 1);
    }
}