class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");
        String v2[] = version2.split("\\.");
        int n = v1.length;
        int m = v2.length;
        int i=0;
        int j=0;
        while(i< n && j < m){
            int x1 = Integer.parseInt(v1[i]);
            int x2 = Integer.parseInt(v2[j]);
            if(x1==x2){
                i++;
                j++;
            }else if(x1 < x2) return -1;
            else return 1;
        }

        while( i < n){
            int x = Integer.parseInt(v1[i]);
            if(x!=0) return 1;
            i++;
        }

        while(j < m){
            int x = Integer.parseInt(v2[j]);
            if(x!=0) return -1;
            j++; 
        }
        return 0;
    }


}