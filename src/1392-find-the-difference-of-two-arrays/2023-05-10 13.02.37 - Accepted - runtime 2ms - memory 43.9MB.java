class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
       
       List<Integer> l1 = get(nums1, nums2);
       List<Integer> l2 = get(nums2, nums1);

       return Arrays.asList(l1, l2);


    }

    private List<Integer> get(int nums1[], int nums2[]){
        boolean visited[] = new boolean[2001];
        for(int x : nums2){
            visited[x+1000] = true;
        }

        List<Integer> list = new ArrayList<>();
        for(int x : nums1){
            if(!visited[x+1000]){
                list.add(x);
                visited[x+1000] = true;
            }
        }

        return list;

    }
}