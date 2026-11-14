package find_duplicate_file_in_system_609;

import java.util.*;
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap();
        for(String s : paths){
            String path[] = s.split(" ");
            String root = path[0];
            for(int i=1;i<path.length;i++){
                String temp [] = path[i].split("\\(");
                String content = temp[1].substring(0, temp[1].length()-1);
                List<String> list = map.get(content);
                if(list==null){
                    list = new ArrayList<String>();
                    list.add(root+"/"+temp[0]);
                    map.put(content, list);
                }else{
                list.add(root+"/"+temp[0]);
                }
            }
        }
        List<List<String>> result = new ArrayList();
    for(Map.Entry<String, List<String>> entry: map.entrySet()){
        if(entry.getValue().size()>1){
            result.add(entry.getValue());
        }
    }
        return result;
    }
}