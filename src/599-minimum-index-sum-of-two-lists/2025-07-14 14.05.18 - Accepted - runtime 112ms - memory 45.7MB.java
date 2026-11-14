class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for(int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){
                if(list1[i].equals(list2[j])){
                    int sum = i+j;

                    map.computeIfAbsent(sum ,s-> new ArrayList<>()).add(list1[i]);
                }
            }
        }

        if(map.isEmpty()){
            return new String[0];
        }

        List<String> list = map.firstEntry().getValue();

        String res[] = new String[list.size()];

        for(int i=0;i<res.length;i++){
            res[i] = list.get(i);
        }

        return res;
    }
}