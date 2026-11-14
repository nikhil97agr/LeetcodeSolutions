class Solution {
    public int score(String[] cards, char x) {
        int pairs = 0;
        int c1[] = new int[10];
        int c2[] = new int[10];
        for(String s : cards){
            boolean a = s.charAt(0) == x;
            boolean b = s.charAt(1) == x;

            if(a && b){
                pairs++;
            }else if(a) c2[s.charAt(1)-'a']++;
            else if(b) c1[s.charAt(0) -'a']++;
        }

        int totalL = 0;
        int maxL = 0;
        int totalR = 0;
        int maxR = 0;

        for(int i=0;i<10;i++){
            totalL += c1[i];
            totalR += c2[i];
            maxL = Math.max(maxL, c1[i]);
            maxR = Math.max(maxR, c2[i]);
        }

        int a = Math.min(
            Math.min(totalL/2, totalL - maxL) + Math.min(totalR/2, totalR - maxR),
            (totalL + totalR - Math.min(pairs, totalL + totalR))/2
        );

        return a + Math.min(pairs, totalL + totalR);
    }
}