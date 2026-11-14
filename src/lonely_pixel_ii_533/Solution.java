package lonely_pixel_ii_533;

import java.util.*;
class Solution {
    public int findBlackPixel(char[][] picture, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = picture.length;
        int n = picture[0].length;
        String row[] = new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(picture[i][j]);
            }
            row[i] = sb.toString();
            map.merge(row[i], 1, Integer::sum);
        }

        int ans = 0;
        int r[] = new int[m];
        int c[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] == 'B'){
                    r[i]++;
                    c[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] == 'B' && r[i] == target && c[j] == target && map.get(row[i]) == target){  
                    ans++;
                }
            }
        }

        return ans;
    }
}