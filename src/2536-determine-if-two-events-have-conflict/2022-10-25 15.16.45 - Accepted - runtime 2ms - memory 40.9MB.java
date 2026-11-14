class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String s1[] = event1[0].split(":");
        String e1[] = event1[1].split(":");
        String s2[] = event2[0].split(":");
        String e2[] = event2[1].split(":");
        if(s1[0].compareTo(e2[0])>0 || (s1[0].compareTo(e2[0])==0&& s1[1].compareTo(e2[1])>0)){
            return false;
        }
        if(s2[0].compareTo(e1[0])>0 || (s2[0].compareTo(e1[0])==0&& s2[1].compareTo(e1[1])>0)){
            return false;
        }
        return true;
        
    }
    
}