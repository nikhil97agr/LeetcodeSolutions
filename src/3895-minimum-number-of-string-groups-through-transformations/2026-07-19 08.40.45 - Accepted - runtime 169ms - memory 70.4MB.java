class Solution {
    public int minimumGroups(String[] words) {
        var set = new HashSet<>();

        for(String w : words){
            if(w.length() <= 2){
                set.add(w);
                continue;
            }

            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();

            for(int i=0;i<w.length();i++){
                if(i%2==0){
                    even.append(w.charAt(i));
                }else{
                    odd.append(w.charAt(i));
                }
            }

            var minE = get(even.toString());
            var minO = get(odd.toString());

            set.add(minE+":"+minO);
        }

        return set.size();
    }

    private String get(String s){
        var n = s.length();
        int i =0;
        int j=1;
        int k = 0;
        while( i < n && j < n && k < n){
            char c1 = s.charAt((i + k)%n);
            char c2 = s.charAt((j + k)%n);

            if(c1 == c2){
                k++;
            }else{
                if(c1 > c2){
                    i += (k + 1);
                }else{
                    j += (k + 1);
                }

                if(i == j){
                    j++;
                }
                k=0;
            }
        }

        return s.substring(Math.min(i , j)) + s.substring(0, Math.min(i, j));
    }
}