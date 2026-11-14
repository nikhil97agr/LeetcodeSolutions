package encode_and_decode_tinyurl_535;

import java.util.*;
class Codec {
    HashMap<String, String> map;
    int next;
    HashMap<String, String> reverseMap;
    public Codec(){
        map = new HashMap();
        reverseMap = new HashMap();
        next = 0;
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(reverseMap.containsKey(longUrl)){
            return reverseMap.get(longUrl);
        }
        StringBuilder url = new StringBuilder("https://u.com/");
        url.append(next++);
        String result = url.toString();
        map.put(result, longUrl);
        reverseMap.put(longUrl, result);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));