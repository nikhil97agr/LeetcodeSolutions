class OrderedStream {
    List<String> list;
    boolean vis[];
    public OrderedStream(int n) {
        list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add("");
        }

        vis= new boolean[n];
    }
    
    public List<String> insert(int idKey, String value) {
        int id = idKey -1;
        list.set(id, value);
        List<String> result = new ArrayList<>();
        int i=0;
        while(i < list.size() && vis[i])i++;
        while(i < list.size() && !vis[i] && !list.get(i).isEmpty()){
            result.add(list.get(i));
            vis[i] = true;
            i++;
        }

        return result;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */