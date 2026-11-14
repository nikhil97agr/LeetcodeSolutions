package path_in_zigzag_labelled_binary_tree_1194;

import java.util.*;
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> result = new ArrayList<>();
        int level = (int)(Math.log(label)/Math.log(2));

        while(level > 0){
            result.add(label);
            int parent= label / 2;
            int end = (1<<level) - 1;
            int diff = end - parent;
            label = (1<<(level - 1)) + diff;
            level--;
        }
        result.add(1);

        Collections.reverse(result);
        return result;
    }
}