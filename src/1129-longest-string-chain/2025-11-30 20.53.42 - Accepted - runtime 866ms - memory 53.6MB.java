class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int n = words.length;
        Arrays.sort(words, (a,b)->{
            return a.length() - b.length();
        });
        for(int i=0;i<n;i++){
            map.put(words[i], i);
        }

        int ans [] = new int[n];

        Arrays.fill(ans, 1);

        for(int i=n-2;i>=0;i--){
            for(char c ='a';c<='z';c++){
                for(int j=0;j<=words[i].length();j++){
                    String s = getNext(words[i], j, c);
                    if(map.containsKey(s)){
                        ans[i] = Math.max(ans[i], ans[map.get(s)] + 1);
                    }
                }
            }
        }

        return Arrays.stream(ans).max().getAsInt();

    }

    private String getNext(String w, int ind, char c){
        if(ind == w.length()){
            return w + c;
        }

        if(ind ==0){
            return ""+c+w;
        }

        return w.substring(0, ind) + c + w.substring(ind);


    }
}