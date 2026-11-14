package search_suggestions_system_1397;

import java.util.*;
class Solution {
    
   
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(products);
        int n = products.length;

        int m = searchWord.length();
        for(int i=0;i<m;i++){
            String sub = searchWord.substring(0,i+1);
            List<String> list = new ArrayList();
            int j =0;
            while(list.size()<3 && j<n){
                if(products[j].startsWith(sub)){
                    list.add(products[j]);
                }
                j++;
            }
            result.add(list);
        }
        
        
        return result;
        
    }
}