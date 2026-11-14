class Solution {

    public int[][] validArrangement(int[][] pairs) {
        Set<Integer> nodes = new HashSet<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();

        for(int p[] : pairs){
            adjList.computeIfAbsent(p[0], x-> new ArrayList<>()).add(p[1]);
            out.put(p[0], out.getOrDefault(p[0], 0)+1);
            in.put(p[1], in.getOrDefault(p[1], 0)+1);
            nodes.add(p[0]);
            nodes.add(p[1]);
        }
        int start = -1;

        for(int x : nodes){
            if(in.getOrDefault(x,0) + 1 == out.getOrDefault(x, 0)){
                start = x;
                break;
            }
        }
        if(start == -1){
            start = pairs[0][0];
        }


        Stack<Integer> stack = new Stack<>();

        dfs(start, adjList, out, stack);

        int ans[][] = new int[pairs.length][2];
        int i =0;
        while(stack.size() > 1){
            ans[i] = new int[]{stack.pop(), stack.peek()};
            i++;
        }

        return ans;
    }
    
    private void dfs(int curr, Map<Integer, List<Integer>> adjList, Map<Integer, Integer> out, Stack<Integer> stack){

        while(out.getOrDefault(curr, 0) !=0){
            int deg = out.get(curr);
            int val = adjList.get(curr).get(deg-1);
            out.put(curr, deg-1);
            dfs(val, adjList, out, stack);
        }

        stack.push(curr);
    }
}