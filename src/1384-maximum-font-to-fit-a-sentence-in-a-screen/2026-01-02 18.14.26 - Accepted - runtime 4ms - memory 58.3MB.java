/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int ans = -1;
        int start = 0;
        int end = fonts.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            int font = fonts[mid];
            int height = fontInfo.getHeight(font);
            if(height > h){
                end = mid - 1;
                continue;
            }
            int width = 0;
            for(char c : text.toCharArray()){
                width += fontInfo.getWidth(font, c);
            }

            if(width > w){
                end = mid - 1;
            }else{
                ans = font;
                start = mid + 1;
            }
        }

        return ans;
    }
}