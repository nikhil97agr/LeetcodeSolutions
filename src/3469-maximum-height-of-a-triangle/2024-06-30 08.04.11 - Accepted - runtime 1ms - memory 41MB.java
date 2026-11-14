class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int ans = Math.max(calc(red, blue, true), calc(red, blue, false));
        return ans;
    }
    
    public int calc(int red, int blue, boolean isBlue){
        int next = 1;
        int ans = 0;
        while(true){
            if(isBlue){
                if(blue >= next){
                    blue -= next;
                    ans++;
                    next++;
                    isBlue= false;
                }else{
                    break;
                }
            }else{
                if(red >= next){
                    red -= next;
                    ans++;
                    isBlue = true;
                    next++;
                }else{
                    break;
                }
            }
        }
        return ans;
    }
}