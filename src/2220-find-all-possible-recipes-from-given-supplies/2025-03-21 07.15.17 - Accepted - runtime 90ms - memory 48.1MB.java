class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> degree = new HashMap<>();
        Map<String, Set<String>> map = new HashMap<>();
        for(String r : recipes) degree.put(r, 0);
        int n = recipes.length;
        for(int i=0;i<n;i++){
            for(String ig: ingredients.get(i)){
                degree.put(recipes[i], degree.get(recipes[i])+1);
                map.computeIfAbsent(ig, s -> new HashSet<>()).add(recipes[i]);
            }
        }
        Queue<String> que = new LinkedList<>();
        for(String s : supplies) que.offer(s);

        List<String> res = new ArrayList<>();
        while(!que.isEmpty()){
            String curr =que.poll();

            if(degree.containsKey(curr) && degree.get(curr) ==0){
                res.add(curr);
            }

            for(String s : map.getOrDefault(curr, new HashSet<>())){
                degree.put(s, degree.get(s)-1);

                if(degree.get(s) == 0){
                    que.offer(s);
                }
            }
        }

        return res;
    }
}