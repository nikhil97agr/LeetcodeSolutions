class Solution {
    public int minCharacters(String a, String b) {
        int ans = cost(a.toCharArray()) + cost(b.toCharArray());

        return Math.min(ans, Math.min(cost(a.toCharArray(), b.toCharArray()), 
        cost(b.toCharArray(), a.toCharArray())));
    }

    private int cost(char a[], char b[]){
        int ans = Integer.MAX_VALUE;
        int n = a.length;
        int m = b.length;
        int prea[] = cnt(a);
        int preb[] = cnt(b);
        
        for(int i=0;i<25;i++){
            int l1 = a.length - prea[i];
            int l2 = preb[i];
            ans = Math.min(ans, l1 + l2);
        }

        return ans;
    }

    private int[] cnt(char arr[]){
        int cnt[] = new int[26];
        for(char c : arr){
            cnt[c-'a']++;
        }
        int pre[] = new int[26];
        pre[0] = cnt[0];
        for(int i=1;i<26;i++){
            pre[i] = pre[i-1] + cnt[i];
        }

        return pre;
    }
    private int cost(char arr[]){
        int cnt[] = new int[26];
        for(char c : arr){
            cnt[c-'a']++;
        }

        int ans = arr.length;

        for(int i=0;i<26;i++){
            ans = Math.min(ans, arr.length - cnt[i]);
        }

        return ans;
    }
}