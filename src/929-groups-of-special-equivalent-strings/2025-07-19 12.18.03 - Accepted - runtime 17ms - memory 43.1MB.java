class Solution {
    public int numSpecialEquivGroups(String[] words) {
        int n = words.length;
        int even[][] = new int[n][26];
        int odd[][] = new int[n][26];

        for(int i=0;i<n;i++){
            char ch[] = words[i].toCharArray();

            for(int j=0;j<ch.length;j++){
                if(j%2==0){
                    even[i][ch[j]-'a']++;
                }else{
                    odd[i][ch[j]-'a']++;
                }
            }
        }

        int grp = 0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                grp++;
                for(int j=i;j<n;j++){
                    if(Arrays.equals(even[i], even[j]) && Arrays.equals(odd[i], odd[j])){
                        vis[j] = true;
                    }
                }
            }
        }

        return grp;
    }
}