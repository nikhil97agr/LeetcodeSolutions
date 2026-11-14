class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : words){
            String st = convert(s, 1);
            if(st.length() == s.length()){
            map.computeIfAbsent(s, x-> new ArrayList<>()).add(s);

            }else
                map.computeIfAbsent(st, x-> new ArrayList<>()).add(s);
        }
        while(map.size() != words.size()){
            Map<String, List<String>> temp = new HashMap<>();

            for(String s : map.keySet()){
                List<String> list = map.get(s);
                if(list.size() == 1){
                    temp.computeIfAbsent(s, x-> new ArrayList<>()).add(list.get(0));
                }else{
                    int ind = -1;
                    for(int i=0;i<s.length();i++){
                        if(!Character.isLetter(s.charAt(i))){
                            ind = i+1;
                            break;
                        }
                    }
                    for(String st : list){
                        String conv = convert(st, ind);
                        if(conv.length() == st.length()){
                        temp.computeIfAbsent(st, x-> new ArrayList<>()).add(st);

                        }else
                        temp.computeIfAbsent(conv, x-> new ArrayList<>()).add(st);
                    }
                }
            }
            map = temp;
        }
        int n = words.size();
        List<String> result= new ArrayList<>();
        for(int i=0;i<n;i++){
            for(String s : map.keySet()){
                if(map.get(s).get(0).equals(words.get(i))){
                    result.add(s);
                    break;
                }
            }
        }
        return result;
    }
    private String convert(String s, int startIndex){
        int n = s.length();
        if(startIndex == -1){
            for(int i=0;i<n;i++){
                if(!Character.isLetter(s.charAt(i))){
                    startIndex = i+1;
                    break;
                }
            }
        }


        StringBuilder res = new StringBuilder(s.substring(0, Math.min(n-1, startIndex)));
        
        int cnt = n-1 - startIndex;
        if(cnt !=0)
            res.append(n-1-startIndex);
        res.append(s.charAt(n-1));

        return res.toString();
    }
}