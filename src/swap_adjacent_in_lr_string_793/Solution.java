package swap_adjacent_in_lr_string_793;

class Solution {
    public boolean canTransform(String start, String end) {
        int n = start.length();
        int i=0;
        int j=0;
        while(i<n && j<n){
            while(i < n && start.charAt(i)=='X'){
                i++;
            }

            while(j<n && end.charAt(j)=='X'){
                j++;
            }
            if(i==n && j==n) continue;
            if(i==n || j==n) return false;

            if(start.charAt(i)!=end.charAt(j)) return false;
            i++;
            j++;
        }
        while(i<n){
            
            if(start.charAt(i)!='X') return false;
            i++;
        }

        while(j<n){
            if(end.charAt(j)!='X') return false;
            j++;
        }

        i=0;
        j=0;
        while(i<n && j<n){
            while(i<n && start.charAt(i)=='X') i++;

            while(j<n && end.charAt(j)=='X') j++;
            if(i==n && j==n) return true;

            if(start.charAt(i)=='L'){
                if(j>i) return false;
                i++;
                j++;
            }else if(start.charAt(i)=='R'){
                if(i>j) return false;
                i++;
                j++;
            }
        }

        return true;
    }

}