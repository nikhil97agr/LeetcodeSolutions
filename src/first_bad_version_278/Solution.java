package first_bad_version_278;

// The isBadVersion API is defined in the parent class VersionControl.
class VersionControl {
    boolean isBadVersion(int version) {
        // The real implementation is provided by the judge.
        throw new UnsupportedOperationException();
    }
}

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while(start<=end){
            if(start==end){
                return start;
            }
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return end;
    }
}