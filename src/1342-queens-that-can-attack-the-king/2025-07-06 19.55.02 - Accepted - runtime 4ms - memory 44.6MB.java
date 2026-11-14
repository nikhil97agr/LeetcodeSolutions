import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().queensAttacktheKing(new int[][]{{0,1},{1,0},{4,0}, {0,4}, {3,3}, {2,4}}, new int[]{0,0});
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer , Set<Integer>> map = new HashMap<>();

        for(int q[] : queens){
            int x= q[0];
            int y = q[1];

            map.computeIfAbsent(x, x1 -> new HashSet<>()).add(y);
        }
        
        for(int q[] : queens){
            if(attacked(q, king, map)){
                list.add(Arrays.asList(q[0], q[1]));
            }
        }

        return list;
    }

    private boolean attacked(int q[], int k[], Map<Integer, Set<Integer>> map){
        int x = q[0];
        int y = q[1];
        for(int i=x;i<8;i++){

            if(check(x, y, i, y, map)) break;
            if(k[0] ==i && k[1] == y) return true;
        }
        
        for(int i=x;i>=0;i--){
            if(check(x, y, i, y, map) ) break;
            if( k[0] ==i && k[1] == y) return true;
        }
        
        for(int i=y;i<8;i++){
            if(check(x, y, x, i, map)) break;
            if( k[0] == x && k[1] == i) return true;
        }
        
        for(int i=y ;i>=0;i--){
            if(check(x, y, x, i, map)) break;
            if( k[0] ==x && k[1] == i) return true;
        }

        for(int i=x,j=y;i<8 && j >=0;i++, j-- ){
            if(check(x, y, i, j, map)) break;
            if( i == k[0] && j == k[1]) return true;
        }

        for(int i=x,j=y; i<8 && j < 8;i++,j++){
            if(check(x, y, i, j, map)) break;
            if(i == k[0] && j == k[1]) return true;
        }

        for(int i=x,j=y; i>=0 && j < 8;i--, j++){
            if(check(x, y, i, j, map)) break;
            if( i==k[0] && j ==k[1]) return true;
        }
        

        for(int i=x, j=y; i>=0 && j >=0; i--, j--){
            if(check(x,y,i, j, map)) break;
            if( i==k[0] && j==k[1]) return true;
        }
        return false;
    }

    private boolean check(int x, int y,int nx, int ny, Map<Integer, Set<Integer>> map){
        if(nx== x && ny == y){
            return false;
        }

        return map.getOrDefault(nx, new HashSet<>()).contains(ny);
    }
}