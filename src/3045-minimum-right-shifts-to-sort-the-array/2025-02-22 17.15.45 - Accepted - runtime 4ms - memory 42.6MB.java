class Solution {
    public int minimumRightShifts(List<Integer> list) {
      int ind = -1;
      int min = 101;
      int n =list.size();

      for(int i=0;i<n;i++){
        int val = list.get(i);
        if(val < min){
            min = val;
            ind = i;
        }
      }
      int shift = n - ind;

      for(int i=0;i<shift;i++){
        rotate(list, ind);
        ind++;
      }

      for(int i=0;i<n-1;i++){
        if(list.get(i) > list.get(i+1)) return -1;
      }

      return shift%n;

    }

    private void rotate(List<Integer> list, int start){
        int rest = list.get(start);
        for(int i=start+1;i<list.size();i++){
            int temp = list.get(i);
            list.set(i, rest);
            rest = temp;
        }
        for(int i=0;i<=start;i++){
            int temp = list.get(i);
            list.set(i, rest);
            rest = temp;
        }

    }
}