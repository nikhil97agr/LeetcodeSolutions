package count_cells_in_overlapping_horizontal_and_vertical_substrings_3821;

import java.util.*;
class Solution {
    public int countCells(char[][] grid, String pattern) {
        int n = grid.length;
        int m = grid[0].length;

        StringBuilder h = new StringBuilder();
        StringBuilder v = new StringBuilder();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                h.append(grid[i][j]);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                v.append(grid[j][i]);
            }
        }

        List<int[]> hIndices= generateIntervals(h.toString(), pattern);
        List<int[]> vIndices= generateIntervals(v.toString(), pattern);

        List<int[]> hMerged = mergeIntervals(hIndices);
        List<int[]> vMerged = mergeIntervals(vIndices);

        if(h.isEmpty() || v.isEmpty()) return 0;
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        for(int i[]: hMerged){
            for(int j=i[0];j<=i[1];j++){
                int r = j/m;
                int c = j%m;
                Pair<Integer, Integer> pair = new Pair<>(r, c);
                set.add(pair);
            }
        }
        int ans = 0;

        for(int i[] : vMerged){
            for(int j=i[0];j<=i[1];j++){
                int c = j/n;
                int r = j%n;

                Pair<Integer, Integer> pair = new Pair<>(r, c);
                if(set.contains(pair)){
                    ans++;
                }
            }
        }

        return ans;
    }

    private List<int[]> mergeIntervals(List<int[]> list){
        Stack<int[]> stack =new Stack<>();
        for(int i[] : list){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(stack.peek()[1]>= i[0]){
                stack.peek()[1]= Math.max(stack.peek()[1], i[1]);
            }else{
                stack.push(i);
            }

        }

        return new ArrayList<>(stack);
    }

    private List<int[]> generateIntervals(String text, String pattern){
        int z[]= zArray(text, pattern);
        List<int[]> list = new ArrayList<>();
        int n = pattern.length();
        for(int i=0;i<z.length;i++){
            if(z[i] == pattern.length()){
                int start = i - n- 1;
                int end = start + n - 1;

                list.add(new int[]{start, end});

            }
        }
        return list;
    }

    private int[] zArray(String text, String pattern){
        String s = pattern + ":"+text;
        char ch[] = s.toCharArray();
        int z[] = new int[ch.length];
        int left = 0;
        int right = 0;
        for(int i=1;i<z.length;i++){
            if( i > right){
                left = right = i;
                while(right < z.length && ch[right] == ch[right- left]){
                    right++;
                }
                z[i] = right - left;
                right--;
            }else{
                int lastIndex = i -left;
                if(z[lastIndex] < right - i + 1){
                    z[i] = z[lastIndex];
                }else{
                    left = i;
                    while(right < ch.length && ch[right] == ch[right- left]){
                        right++;
                    }
                    z[i] = right- left;
                    right--;
                }
            }
        }

        return z;
    }
}