/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder path = new StringBuilder("[");
        serialize(root, path);
        path.append("]");
        
        return path.toString();
    }

    private void serialize(Node root, StringBuilder path){
        if(root==null) return;

        path.append(root.val+" ");
        if(root.children!=null && !root.children.isEmpty()){
            path.append("[");
            for(Node child : root.children){
                serialize(child, path);
            }
            path.append("]");   
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<Character> q = new LinkedList<>();
        for(char c : data.toCharArray()) q.add(c);
        q.poll();
        List<Node> result = deserialize(q);
        if(result.isEmpty()) return null;
        
        return result.get(0);

    }

    public List<Node> deserialize(Queue<Character> que){
        List<Node> list = new ArrayList<>();
        while(!que.isEmpty()){
            while(!que.isEmpty() && que.peek()==' ') que.poll();
            int number = 0;
            if(Character.isDigit(que.peek())){
                while(!que.isEmpty() && Character.isDigit(que.peek())){
                number = number*10+(que.poll()-'0');
                }
                Node node = new Node(number, new ArrayList<>());
                list.add(node);
            }else if(que.peek()=='['){
                que.poll();
                list.get(list.size()-1).children = deserialize(que);
            }else{
                que.poll();
                return list;
            }



        }

        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));