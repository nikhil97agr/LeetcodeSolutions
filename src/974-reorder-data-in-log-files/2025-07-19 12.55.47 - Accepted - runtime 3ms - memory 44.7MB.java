class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> dig = new ArrayList<>();
        List<String> let = new ArrayList<>();

        int n = logs.length;
        for(String s : logs){
            String content = s.substring(s.indexOf(" ")+1);

            if(Character.isDigit(content.charAt(0))){
                dig.add(s);
            }else{
                let.add(s);
            }
        
        }
        Collections.sort(let, (a,b)->{
            int ind = a.indexOf(" ");

            String s1[]= new String[]{a.substring(0, ind), a.substring(ind+1)};

            ind = b.indexOf(" ");
            String s2[] = new String[]{b.substring(0, ind), b.substring(ind+1)};
            if(s1[1].equals(s2[1])) return s1[0].compareTo(s2[0]);
            return s1[1].compareTo(s2[1]);
        });

        String res[] = new String[n];

        int ind = 0;
        for(int i=0;i<let.size();i++){
            res[ind++] = let.get(i);
        }

        for(int i=0;i<dig.size();i++){
            res[ind++] = dig.get(i);
        }

        return res;
    }
}