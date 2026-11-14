class SQL {
    Map<String, Integer> nextId;
    Map<String, Map<Integer, List<String>>> data;
    public SQL(List<String> names, List<Integer> columns) {
        nextId = new HashMap<>();
        data = new HashMap<>();
        for(String table : names){
            nextId.put(table, 1);
            data.put(table, new HashMap<>());
        }
    }
    
    public void insertRow(String name, List<String> row) {
        Map<Integer, List<String>> map = data.get(name);
        int id = nextId.get(name);
        nextId.put(name, id+1);
        map.put(id,row);
    }
    
    public void deleteRow(String name, int rowId) {
        data.get(name).remove(rowId);
    }
    
    public String selectCell(String name, int rowId, int columnId) {
        String row = data.get(name).get(rowId).get(columnId-1);
        return row;
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */