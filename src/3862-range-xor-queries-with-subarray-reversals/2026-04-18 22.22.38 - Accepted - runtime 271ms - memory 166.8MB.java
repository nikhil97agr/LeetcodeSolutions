class Solution {
    public int[] getResults(int[] nums, int[][] queries) {
            AvlTree root = new AvlTree(nums, 0, nums.length- 1);
            List<Integer> result = new ArrayList<>();

            for(var q : queries){
                if(q[0] == 1){
                    root.update(q[1], q[2]);
                }else if(q[0] == 2){
                    result.add(root.query(q[1], q[2]));
                }else if(q[1] < q[2]){
                    SplitResult r1 = root.split(q[2]);
                    SplitResult r2 = r1.left != null ? r1.left.split(q[1]) : new SplitResult(null, null, null);
                    var left = r2.left;
                    var right = r2.right;
                    if(right !=null){
                        right.flip();
                    }

                   var joinedLeft = r1.mid.join(left, right);
                   root = r2.mid.join(joinedLeft, r1.right);
                }
            }

            return result.stream().mapToInt(x-> x).toArray();
    }
}

class AvlTree {
    int size;
    int height;
    int balance;
    int val;
    int xor;
    boolean reverse;
    AvlTree left, right;

    public AvlTree(int arr[], int l, int r) {
        var mid = l + (r - l)/2;
        val = arr[mid];
        if (l < mid) {
            left = new AvlTree(arr, l, mid-1);

        }
        if (mid < r) {
            right = new AvlTree(arr, mid + 1, r);

        }
        update();
    }

    public SplitResult split(int ind){
        reverse();
        int leftSize = left == null ? 0 : left.size;

        if(leftSize == ind){
            AvlTree l = left, r = right;
            left = null;
            right = null;
            return new SplitResult(l, this, r);
        }

        if(leftSize > ind){
            SplitResult res = left.split(ind);
            return new SplitResult(res.left, res.mid, join(res.right, right));
        }

        SplitResult res = right.split(ind - leftSize - 1);
        return new SplitResult(join(left, res.left), res.mid, res.right);
    }

    public AvlTree join(AvlTree left, AvlTree right){
        int leftHeight = left == null ? 0 : left.height;
        int rightHeight = right == null ? 0 : right.height;
        if(rightHeight > leftHeight + 1){
            right.reverse();
            right.left = join(left, right.left);
            right.rebalance();
            return right;
        }

        if(leftHeight > rightHeight + 1){
            left.reverse();
            left.right = join(left.right, right);
            left.rebalance();
            return left;
        }

        this.left = left;
        this.right = right;
        update();
        return this;
    }

    public void update(int index, int val){
        reverse();
        int leftSize = left == null ? 0 : left.size;
        if(leftSize == index){
            this.val = val;
        }else if(leftSize > index){
            left.update(index, val);
        }else{
            right.update(index - leftSize - 1, val);
        }

        update();
    }

    public int query(int l, int r){
        if(r - l + 1 == size){
            return xor;
        }

        reverse();
        int leftSize = left == null ? 0 : left.size;
        if(r < leftSize){
            return left.query(l,r);
        }
        if(l > leftSize){
            return right.query(l - leftSize - 1, r - leftSize - 1);
        }
        int ans = val;
        if(l < leftSize){
            ans ^= left.query(l,leftSize - 1);
        }

        if(r > leftSize){
            ans ^= right.query(0, r - leftSize - 1);
        }

        return ans;
    }




    public void rebalance(){
        update();
        if(balance == 2){
            left.reverse();
            if(left.balance == -1){
                left.right.reverse();
                left.leftRotate();
            }
            rightRotate();
        }else if(balance == -2){
            right.reverse();
            if(right.balance == 1){
                right.left.reverse();
                right.rightRotate();
            }
            leftRotate();
        }
    }



    public void reverse(){
        if(reverse){
            AvlTree left = this.left;
            AvlTree right = this.right;
            this.right = left;
            this.left = right;
            if(left != null){
                left.flip();
            }
            if(right != null){
                right.flip();
            }
            balance = -balance;
            reverse = false;
        }
    }

    public void flip(){
        reverse = !reverse;
    }


    public void rightRotate(){
        int lVal = left.val, rVal = val;
        AvlTree prevLeft = left;
        left = prevLeft.left;
        prevLeft.left = prevLeft.right;
        prevLeft.right = right;
        right = prevLeft;
        right.val = rVal;
        val =lVal;
        right.update();
        update();
    }

    public void leftRotate(){
        int lVal = this.val;
        int rVal = right.val;
        AvlTree prevRight = right;
        right = prevRight.right;
        prevRight.right = prevRight.left;
        prevRight.left = left;
        left = prevRight;
        left.val = lVal;
        val = rVal;
        left.update();
        update();
    }

    public void update(){
        int leftXor=0, rightXor=0, leftSize=0, rightSize=0, leftHeight=0, rightHeight=0;

        if(left != null){
            leftXor = left.xor;
            leftSize = left.size;
            leftHeight = left.height;
        }

        if(right !=null){
            rightXor = right.xor;
            rightSize = right.size;
            rightHeight = right.height;
        }

        xor = leftXor ^ rightXor ^ val;
        size = leftSize + rightSize + 1;
        height = Math.max(leftHeight, rightHeight ) + 1;
        balance = leftHeight - rightHeight;

    }
}

class SplitResult{
    AvlTree left, right, mid;

    public SplitResult(AvlTree left, AvlTree mid, AvlTree right){
        this.left = left;
        this.mid = mid;
        this.right = right;
    }
}