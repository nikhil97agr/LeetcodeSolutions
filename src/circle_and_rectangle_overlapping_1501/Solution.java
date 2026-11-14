package circle_and_rectangle_overlapping_1501;

class Solution {
    public boolean checkOverlap(int r, int x, int y, int x1, int y1, int x2, int y2) {
        int nearY = (y1 <= y && y<=y2) ? 0 : Math.min(Math.abs(y-y1), Math.abs(y-y2));
        int nearX = (x1 <= x && x <= x2 ) ? 0 : Math.min(Math.abs(x-x1), Math.abs(x-x2));

        return Math.pow(nearY, 2) + Math.pow(nearX, 2) <= Math.pow(r,2);
    }
}