class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        int m = firstList.length;
        int n = secondList.length;
        List<int[]> list = new ArrayList<>();
        while(i<m &&j<n){
            int a[] = firstList[i];
            int b[] = secondList[j];
            if(!overlap(a,b)){
                if(a[0]<b[0]){
                    i++;
                }else{
                    j++;
                }
                continue;
            }
            list.add(new int[]{Math.max(a[0],b[0]), Math.min(a[1], b[1])});
            if(Math.min(a[1],b[1])==b[1]){
                j++;
            }else{
                i++;
            }
        }            
        return list.toArray(new int[0][]);

    }

    private boolean overlap(int a[], int b[]){
        if(a[0]>=b[0] && a[0]<=b[1]){
            return true;
        }
        if(a[1]>=b[0] && a[1] <= b[1]){
            return true;
        }

        if(b[0]>=a[0] && b[0] <= a[1]){
            return true;
        }

        if(b[1]>=a[0] && b[1]<=a[1]){
            return true;
        }
        return false;
    }
}