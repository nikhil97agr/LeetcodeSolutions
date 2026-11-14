/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        if(node==null){
            return null;
        }
        Queue<Node> que = new LinkedList<>();

        Node t = node;
        que.add(node);
        map.put(node.val, new Node(node.val));
        while(!que.isEmpty()){
            node = que.poll();
            for(Node n : node.neighbors){
                Node temp = new Node(n.val);
                if(!map.containsKey(n.val)){
                    que.add(n);
                    map.put(n.val, temp);
                    map.get(node.val).neighbors.add(temp);
                }
                else{
                    temp = map.get(n.val);
                    map.get(node.val).neighbors.add(temp);
                }
            }
        }
        return map.get(t.val);
    }
}