import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<Quad> result = new HashSet<>();
        int n = nums.length;

        Map<Long, TreeSet<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(1l*nums[i], ax-> new TreeSet<>()).add(i);
        }


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    long req = 1l*target - nums[i] - nums[j] - nums[k];
                    if(map.containsKey(req) && map.get(req).last() > k){
                        int arr[] = new int[]{nums[i], nums[j], nums[k], (int)req};

                        Arrays.sort(arr);
                        result.add(new Quad(arr[0], arr[1], arr[2], arr[3]));
                    }
                }
            }
        }


        return result.stream().map(q -> Arrays.asList(q.a, q.b, q.c, q.d)).toList();
    }



    class Quad{
        int a;
        int b;
        int c;
        int d;

        public Quad(int a, int b, int c, int d){
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quad quad = (Quad) o;
            return a == quad.a && b == quad.b && c == quad.c && d == quad.d;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }
}