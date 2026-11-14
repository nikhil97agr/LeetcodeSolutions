class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> res = new ArrayList<>();

        String arr[] = text.split(" ");

        for(int i=0;i<arr.length-2;i++){
            if(arr[i].equals(first) && arr[i+1].equals(second)){
                res.add(arr[i+2]);
            }
        }

        return res.toArray(new String[0]);
    }
}