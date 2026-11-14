class Encrypter {
    Map<Character, Integer> keys;
    String val[];
    Map<String, Integer> map;
    
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.keys = new HashMap<>();
        for(int i=0;i<keys.length;i++){
            this.keys.put(keys[i], i);
        }
        this.val = values;


        map = new HashMap<>();

        for(String s : dictionary){
            String e = encrypt(s);
            map.merge(e, 1, Integer::sum);
        }

    }
    
    public String encrypt(String word1) {
        StringBuilder res = new StringBuilder();
        for(char c : word1.toCharArray()){
            int ind = keys.getOrDefault(c, -1);
            if(ind == -1) return "";
            res.append(val[ind]);
        }

        return res.toString();
    }
    
    public int decrypt(String word2) {
        return map.getOrDefault(word2, 0);
    }


}


/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */