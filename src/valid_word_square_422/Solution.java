package valid_word_square_422;

import java.util.*;
class Solution {
    public boolean validWordSquare(List<String> words) {
        int m = words.size();
        int n = words.stream().map(x -> x.length()).max(Integer::compareTo).get();
        if(n!=m) return false;
        char grid[][] = new char[m][n];

        for(int i=0;i<m;i++){
            char ch[] = words.get(i).toCharArray();
            int j=0;
            for(;j<ch.length;j++){
                grid[i][j] = ch[j];
            }

        }

        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                if(grid[i][j] != grid[j][i]) return false;
            }
        }
        return true;
    }
}