class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
                int m = potions.length;
        int n = spells.length;
        int result[] = new int[n];


        for(int i=0;i<n;i++){
            int start = 0;
            int cnt = 0;
            int end =m-1;
            while(start<=end){
                int mid = (start+end)/2;
                if(start==end){
                    if(1l*spells[i]*potions[mid]>=success){
                    cnt = max(cnt, m-mid);
                    end = mid;
                }
                break;
                }
                if(1l*spells[i]*potions[mid]>=success){
                    cnt = max(cnt, m-mid);
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            result[i] = cnt;
        }

        return result;
    }

    private int max(int...a){
        int max = Integer.MIN_VALUE;
        for(int x : a){
            max = Math.max(x, max);
        }

        return max;
    }
}