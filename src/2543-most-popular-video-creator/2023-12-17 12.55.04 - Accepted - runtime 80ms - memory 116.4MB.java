class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Long> creatorView = new HashMap<>();
         Map<String, PriorityQueue<Pair>> creatorId = new HashMap<>();
         int n = creators.length;
         for(int i=0;i<n;i++){
             creatorView.put(creators[i], creatorView.getOrDefault(creators[i], 0l)+ 1l*views[i]);
             creatorId.computeIfAbsent(creators[i], creator->new PriorityQueue<>(new PairComparator())).offer(new  Pair(ids[i], views[i]));
         }
         long view = 0;
         for(long v : creatorView.values()){
             view = Math.max(view, v);
         }

         List<List<String>> result = new ArrayList<>();
         for(Map.Entry<String, Long> entry : creatorView.entrySet()){
             if(entry.getValue()== view){
                 String creator = entry.getKey();
                 Pair pair = creatorId.get(creator).peek();
                 result.add(Arrays.asList(creator, pair.id));
             }
         }
         return result;
    }

    class Pair{
        String id;
        int view;
        public Pair(String id, int view){
            this.id = id;
            this.view = view;
        }


    }

    class PairComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            if(p1.view == p2.view) return p1.id.compareTo(p2.id);
            return p2.view - p1.view;
        }
    }
}