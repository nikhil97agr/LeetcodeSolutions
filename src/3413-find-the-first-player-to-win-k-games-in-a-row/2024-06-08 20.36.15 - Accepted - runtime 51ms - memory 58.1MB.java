class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;

            int maxValue =0;
            int maxIndex = -1;
            for(int i=0;i<n;i++){
                if(skills[i] > maxValue){
                    maxValue = skills[i];
                    maxIndex = i;
                }

        }
        
        if(k >= n-1){
            return maxIndex;
        }
        int nge[] = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && skills[i] > skills[stack.peek()]){
                nge[stack.pop()] = i;
            }
            
            stack.push(i);
            
        }
        int prev = -1;
        int i=0;
        while(nge[i]!=-1){
            
            if(prev == -1){
                if((i-prev-1) + (nge[i] -i -1) >=k){
                    return i;
                }
                prev = i;
            }else{
                if(skills[i] >skills[prev]){
                    if(nge[i]-i >= k){
                        return i;
                    }
                    prev = i;
                }
            }
            
            i++;
        }
        
        return maxIndex;
        
        
        
    }
}