class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        String sep = "\\"+separator;
        System.out.println(sep);
        for(String s : words){
            String split[] = s.split(sep);

            list.addAll(Arrays.asList(split));
        }

        return list.stream().filter(s -> !s.isEmpty()).toList();
    }
}