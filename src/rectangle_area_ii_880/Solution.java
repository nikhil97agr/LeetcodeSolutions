package rectangle_area_ii_880;

import java.util.*;
class Solution {
    public int rectangleArea(int[][] rectangles) {
        List<int[]> list = new ArrayList<>();
        for(int r[] : rectangles){
            list.add(new int[]{r[0], r[1], r[3], 1});
            list.add(new int[]{r[2], r[1], r[3], -1});
        }
        int ans = 0;
        Collections.sort(list, (a,b) -> a[0] - b[0]);
        List<int[]> curr = new ArrayList<>();
        int prev = list.get(0)[0];
        for(int l[] : list){
            int x = l[0];

            int width = x- prev;

            if(width > 0){
                int height = calcHeight(curr);
                ans = add(ans, prod(width, height));
            }

            if(l[3] == 1){
                curr.add(new int[]{l[1], l[2]});
            }else{
                remove(curr, l[1], l[2]);
            }

            prev = x;
        }

        return ans;
    }

    private int calcHeight(List<int[]> list){
        if(list.isEmpty()) return 0;
        Collections.sort(list, (a,b)-> a[0] - b[0]);
        int total = 0;
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for(int i=1;i < list.size();i++){
            int next[] = list.get(i);

            if(next[0] > end){
                total += end - start;
                start = next[0];
                end = next[1];
            }else{
                end = Math.max(end, next[1]);
            }
        }

        return total + end - start;
    }

    private void remove(List<int[]> list, int y1, int y2){
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0] == y1 && list.get(i)[1] == y2){
                list.remove(i);
                return;
            }
        }
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l * a + b;
        return (int)(sum%mod);
    }

    private int prod(int a, int b){
        long prod =1l * a * b;
        long mod = (long)1e9 + 7;
        return (int)(prod%mod);
    }
}