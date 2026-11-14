package number_of_ways_to_split_a_string_1678;

class Solution {
    public int numWays(String s) {
        int ans = 0;
        int n = s.length();
        int pre[] = new int[n];
        pre[0] = s.charAt(0)-'0';

        for(int i=1;i<n;i++) pre[i] = pre[i-1] + (s.charAt(i) - '0');

        for(int i=0;i<n-2;i++){
            int ind1 = -1;
            int ind2 = -1;
            int req = pre[i];
            int start = i+1;
            int end =  n-2;
            
            while(start <= end){
                int mid = (start + end)/2;
                
                int diff1 = pre[mid] - pre[i];
                int diff2 = pre[n-1] - pre[mid];
                
                if(diff1 > req){
                    end = mid-1;
                }else if(diff1 < req){
                    start = mid + 1;
                }else{
                    if(diff2 > req){
                        start = mid + 1;
                    }else if(diff2 < req){
                        end = mid-1;
                    }else{
                        ind1 = mid;
                        end= mid-1;
                    }
                }
            }
            
            start =i+1;
            end = n-2;
            
            while(start <= end){
                int mid = (start + end)/2;
                
                int diff1 = pre[mid] - pre[i];
                int diff2 = pre[n-1] - pre[mid];
                
                if(diff1 > req){
                    end = mid-1;
                }else if(diff1 < req){
                    start = mid+1;
                }else{
                    if(diff2 > req){
                        start = mid + 1;
                    }else if(diff2 < req){
                        end = mid-1;
                    }else{
                        ind2 = mid;
                        start = mid + 1;
                    }
                }
                
            }
            
            if(ind1 == -1 || ind2 == -1){
                continue;
            }
            
            ans = add(ans, ind2 - ind1 + 1);
            


        }

        return ans;
    }

    int add(int a, int b){
        long mod= (long)1e9 + 7;
        long sum = (long) a + b;

        return (int)(sum%mod);
    }
}