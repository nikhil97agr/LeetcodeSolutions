class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            boolean res= false;
            for(int j=0;j<n;j++){
                if(i!=j && words[j].contains(words[i])){
                    res = true;
                    break;
                }
            }
            if(res){
                list.add(words[i]);
            }
        }
        return list;
    }
}