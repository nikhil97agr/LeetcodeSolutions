class Solution {

    public int maxDepthBST(int[] order) {
        List<int[]> list = new ArrayList<>();
        int size = 0;
        for(int o : order){
            int ind = search(list, o);

            int depth = 1;
            if(list.isEmpty()){
                list.add(new int[]{o, depth});
                size++;
                continue;
            }

            if(ind == -1){
                int d = list.get(size-1)[1];
                list.add(new int[]{o, Math.max(depth, d+1)});
                size++;
                continue;
            }

            if(ind == 0){
                int d = list.get(0)[1];
                list.add(0,new int[]{o, Math.max(depth, d+ 1)});
                size++;
                continue;
            }

            depth = Math.max(depth, Math.max(list.get(ind)[1] , list.get(ind-1)[1])+1);

            list.add(ind, new int[]{o, depth});
            size++;
        }

        return list.stream().mapToInt(x -> x[1]).max().getAsInt();
    }

    private int search(List<int[]> list, int val){
        int ind = -1;
        int start = 0;
        int end = list.size() - 1;

        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid)[0] < val){
                ind = mid;
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }

        return ind;
    }


}