class Solution {
    public List<Integer> peopleIndexes(List<List<String>> companies) {
        List<Set<String>> list = new ArrayList<>();
        for(List<String> l : companies){
            list.add(new HashSet<>(l));
        }
        int n = companies.size();
        Set<Integer> res = new HashSet<>();
        for(int i=0;i<n;i++) res.add(i);
        for(int i=0;i<n;i++){
            Set<String> set = list.get(i);
            for(int j=0;j<n;j++){
                boolean result =true;
                if(i!=j){
                    for(String x : set){
                        if(!list.get(j).contains(x)){
                            result = false;
                            break;
                        }
                    }
                    if(result){
                        res.remove(i);
                        break;
                    }
                }

            }
        }

        List<Integer> result = new ArrayList<>(res);
        Collections.sort(result);
        return result;
    }
}