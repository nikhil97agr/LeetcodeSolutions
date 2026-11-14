public class Codec {
    Map<String, List<String>> map = new HashMap<>();
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for(String s : strs){
            encode.append(s+":");
        }
        map.put(encode.toString(), strs);
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return map.getOrDefault(s, new ArrayList<>());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));