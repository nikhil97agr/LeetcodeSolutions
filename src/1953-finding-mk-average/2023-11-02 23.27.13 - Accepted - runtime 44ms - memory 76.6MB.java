class MKAverage {
    TreeMap<Integer, Integer> left;
    TreeMap<Integer, Integer> mid;
    TreeMap<Integer, Integer> right;
    int size;
    long sum;
    Queue<Integer> que;
    int k;
    int m;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        left = new TreeMap<>();
        mid = new TreeMap<>();
        right = new TreeMap<>();
        size = 0;
        sum = 0l;
        que = new LinkedList<>();
    }
    
    public void addElement(int num) {
        que.add(num);

        if(size==m){
            int rmEle = que.poll();

            if(rmEle == num) return;
            boolean lRm = false;
            boolean rRm = false;
            if(mid.firstKey()<=rmEle && rmEle <= mid.lastKey()){
                removeEle(mid, rmEle);
                sum -= rmEle;

            }else if(rmEle <= left.lastKey()){
                lRm = true;
                removeEle(left, rmEle);
            }else if(rmEle >= right.firstKey()){
                rRm = true;
                removeEle(right, rmEle);
            }

            sum += num;
            add(mid, num);

            if(lRm){
                int key = mid.firstKey();
                removeEle(mid, key);
                sum -= key;
                add(left, key);
            }else if(rRm){
                int key = mid.lastKey();
                removeEle(mid, key);
                sum -= key;
                add(right, key);
            }
            fix(mid, right);
            fix(left, mid);
            return;

        }

        if(size<k){
            add(left, num);
        }else{
            int leftKey = left.lastKey();
            if(num < leftKey){
                add(left, num);
                removeEle(left, leftKey);
                num = leftKey;
            }

            if(size < 2*k){
                add(right, num);
            }else{
                int rightKey = right.firstKey();
                if(num > rightKey){
                    add(right, num);
                    removeEle(right, rightKey);
                    num = rightKey;
                }

                add(mid, num);
                sum += num;
            }
        }




        size++;
    }

    private void fix(TreeMap<Integer, Integer> left, TreeMap<Integer, Integer> right){
        if(left.lastKey() > right.firstKey()){
            int leftKey = left.lastKey();
            
            int rightKey = right.firstKey();
            removeEle(left, leftKey);
            add(right, leftKey);
            removeEle(right, rightKey);
            add(left, rightKey);

            if(left==mid){
                sum = sum - leftKey + rightKey;
            }else{
                sum = sum - rightKey + leftKey;
            }

        }
    }

    private void add(TreeMap<Integer, Integer> map, int val){
        map.put(val, map.getOrDefault(val, 0)+1);
    }

    private void removeEle(TreeMap<Integer, Integer> map, int key){
        int cnt = map.get(key);
        if(cnt == 1){
            map.remove(key);
        }else{
            map.put(key, cnt-1);
        }
    }
    
    public int calculateMKAverage() {
        if(size < m) return -1;

        return (int)(sum /(size - 2*k));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */