class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> que =new PriorityQueue<>((p1, p2) -> Double.compare(p2.fraction, p1.fraction));
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1; j<n;j++){
                double fraction = (1d*arr[i])/(1d*arr[j]);
                que.offer(new Pair(arr[i], arr[j], fraction));
                if(que.size()>k) que.poll();
            }
        }

        return new int[]{que.peek().a, que.peek().b};
    }

    class Pair{
        int a;
        int b;
        double fraction;

        public Pair(int a, int b, double fraction){
            this.a = a;
            this.b = b;
            this.fraction = fraction;
        }
    }
}