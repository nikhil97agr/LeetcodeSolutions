/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Cell{
        TreeNode node;
        int c;
        public Cell(TreeNode node, int c){
            this.node = node;
            this.c = c;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        PriorityQueue<Cell> que =new PriorityQueue<>((a,b)->a.node.val - b.node.val);
        que.offer(new Cell(root, 0));

        while(!que.isEmpty()){
            int size = que.size();
            PriorityQueue<Cell> temp = new PriorityQueue<>((a,b)-> a.node.val - b.node.val);
            for(int i=0;i<size;i++){
                Cell cell = que.poll();
                map.computeIfAbsent(cell.c, c-> new ArrayList<>()).add(cell.node.val);

                if(cell.node.left !=null){
                    temp.offer(new Cell(cell.node.left, cell.c-1));
                }

                if(cell.node.right !=null){
                    temp.offer( new Cell(cell.node.right, cell.c+1));
                }
            }
            que = temp;
        }

        return map.values().stream().collect(Collectors.toList());
    }
}