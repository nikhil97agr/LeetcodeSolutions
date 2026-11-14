class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String temp = new String(c);
            List<String> list = map.get(temp);
            if(list==null){
                list = new ArrayList();
                list.add(s);
                map.put(temp, list);
            }else{
                list.add(s);
            }
            
        }
        List<List<String>> result = new ArrayList<List<String>>(map.values());
        // for(Map.Entry<String, List<String>> entry : map.entrySet()){
        //         result.add(entry.getValue());
        // }
        return result;
    }
}