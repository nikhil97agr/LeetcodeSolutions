class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> list = new ArrayList<>();
        Arrays.sort(words);
        int n = words.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;

                for(int k=0;k<n;k++){
                    if(i==k || j ==k) continue;

                    for(int l=0;l<n;l++){
                        if(i==l || j==l || k==l) continue;

                        String top =words[i];
                        String left = words[j];
                        String right = words[k];
                        String bottom = words[l];
                        if(top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) && bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)){
                            list.add(List.of(top, left, right, bottom));
                            
                        }
                    }
                }
            }
        }

        return list;
    }
}