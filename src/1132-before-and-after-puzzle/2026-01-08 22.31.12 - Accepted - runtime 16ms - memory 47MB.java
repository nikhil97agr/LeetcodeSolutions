class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Set<String> result= new HashSet<>();
        int n = phrases.length;
        String str[][] = new String[n][];

        for(int i=0;i<n;i++) str[i] = phrases[i].split(" ");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int n1 = str[i].length;
                int n2 = str[j].length;
                if(str[i][n1-1].equals(str[j][0])){
                    StringBuilder res= new StringBuilder(String.join(" ",str[i]));
                    for(int k=1;k<n2;k++){
                        res.append(" "+str[j][k]);
                    }
                result.add(res.toString());
                }
            }
        }
        return result.stream().sorted().toList();
    }
}