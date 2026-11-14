class ValidWordAbbr {
    Map<String, Set<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String w : dictionary){
            int n = w.length();
            String abbr = "";
            if(n<=2){
                abbr = w;
            }else{
                abbr = ""+w.charAt(0) + (n-2) + w.charAt(n-1);
            }

            map.computeIfAbsent(abbr, word -> new HashSet<>()).add(w);
        }
        System.out.println(map);
    }
    
    public boolean isUnique(String word) {
        String abbr = "";
        int n = word.length();

        if(n <= 2){
            abbr = word;
        }else{
            abbr = ""+word.charAt(0) +(n-2)+ word.charAt(n-1);
        }
        System.out.println(abbr+":"+word);
        return !map.containsKey(abbr) || (map.get(abbr).contains(word) && map.get(abbr).size()==1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */