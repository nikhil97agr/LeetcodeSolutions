
class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long res = 0;
        List<Integer> list =new ArrayList<>();
        int n = nums1.length;

        for(int i=0;i<n;i++){
            int d1 = nums1[i] - nums2[i];
            int d2 = nums2[i] - nums1[i];
            int cnt = binarySearch(list, d2);
            res += cnt;

            int ind = Collections.binarySearch(list, d1);

            if(ind < 0){
                ind  = -ind -1;
                
            }
            if(ind < list.size()){
                list.add(ind, d1);
            }else{
                list.add(d1);
            }
        }

        return res;
    }

    private int binarySearch(List<Integer> list, int val){
        int cnt = 0;
        int n = list.size();
        int start = 0;
        int end = list.size() - 1;
        while(start <= end){
            int mid = (start + end) / 2;

            if(list.get(mid) <= val){
                start = mid + 1;
            }else{
                cnt = n - mid;
                end= mid -1;
            }
        }

        return cnt;
    }
}