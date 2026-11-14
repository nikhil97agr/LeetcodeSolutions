class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        if(n==1){
            if(hamsters.charAt(0)=='H'){
                return -1;
            }
            return 0;
        }
        boolean buckets[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(hamsters.charAt(i)=='.'){
                continue;
            }
            if(i==0){
                
                    if(hamsters.charAt(i+1)=='.') buckets[i+1] = true;
                    else return -1;
                
                continue;
            }
            if(i==n-1){
                    if(hamsters.charAt(i-1)=='.') buckets[i-1] = true;
                    else return -1;
                continue;
            }
            if(hamsters.charAt(i)=='H'){
                if(!buckets[i-1]){
                    if(hamsters.charAt(i+1)=='.'){
                        buckets[i+1] = true;
                    }else if(hamsters.charAt(i-1)=='.'){
                        buckets[i-1] = true;
                    }else{
                        return -1;
                    }
                }
                
            }
        }
        int count = 0;
        for(boolean b : buckets){
            if(b) count++;
        }
        return count;
    }
}