package ip_to_cidr_752;

import java.util.*;
class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        long val = ipToLong(ip);
        while( n > 0){
            long lowest = (val & (-val));
            if(val == 0){
                lowest = (long)Math.pow(2, 31);
            }
            while(lowest > n){
                lowest >>= 1;
            }

            long pre = 32 - (int)(Math.log(lowest)/Math.log(2));
            String res = longToIp(val)+"/"+pre;
            result.add(res);
            val += lowest;
            n -= lowest;
        }

        return result;
    }

    private String longToIp(long ip){
        String res = String.format("%d.%d.%d.%d",
            (ip >> 24) & 255,
            (ip >> 16) & 255,
            (ip >> 8) & 255,
            ip & 255
        );
        return res;
    }

    private long ipToLong(String s){
        String nums[] = s.split("\\.");
        long ip = 0;
        for(String st : nums){
            ip =ip * 256 + Integer.parseInt(st);
        }

        return ip;
    }


}