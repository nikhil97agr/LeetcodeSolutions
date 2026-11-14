package count_the_repetitions_466;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1 = s1.length();
        int l2 = s2.length();
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        int cnt[] =new int[l2];

        for(int i=0;i<l2;i++){
            int i1 = 0;
            int i2 = i;
            while(i1 < l1){
                if(c1[i1] == c2[i2%l2]){
                    i1++;
                    i2++;
                }else{
                    i1++;
                }
            }

            cnt[i] = i2 - i;
        }
        int totalSize = 0;
        int j = 0;
        for(int i=0;i<n1;i++){
            totalSize += cnt[j];
            j+= cnt[j];
            j%=l2;
        }


        return totalSize/(l2 * n2);
    }
}