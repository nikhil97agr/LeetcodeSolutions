class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> result = new ArrayList<>();
        int degree[] =new int[n];
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
            result.add(new HashSet<>());
        }
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            degree[e[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==0) que.add(i);
        }

        while(!que.isEmpty()){
            int node = que.poll();

            for(int x : adjList[node]){
                degree[x]--;
                result.get(x).addAll(result.get(node));
                result.get(x).add(node);
                if(degree[x]==0){
                    que.offer(x);
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for(Set<Integer> set : result){
            list.add(set.stream().sorted().collect(Collectors.toList()));
        }
        return list;

    }
}