class Solution {
    public String generateTag(String caption) {
        StringBuilder res = new StringBuilder("#");
        boolean first = true;
        for(String s : caption.split(" ")){
            s = removeSpaces(s);
            if(s.isEmpty()) continue;
            if(first){
                String temp = s.toLowerCase();
                res.append(temp);
                first = false;
            }else{
                String temp = s.toLowerCase();
                res.append(Character.toUpperCase(temp.charAt(0)));
                res.append(temp.substring(1));
            }
        }
        return res.toString().substring(0, Math.min(res.length(), 100));
    }
    
    private String removeSpaces(String s){
        StringBuilder res = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if(c == ' '){
                continue;
            }
            res.append(c);
        }
        
        return res.toString();
    }
}