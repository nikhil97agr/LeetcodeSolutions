class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<Transaction> list = new ArrayList<>();
        for(String t : transactions){
            String st[] = t.split(",");

            list.add(new Transaction(st[0], Integer.parseInt(st[1]), Integer.parseInt(st[2]), st[3]));
        }
        int n = transactions.length;
        List<String> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            Transaction t = list.get(i);
            for(int j=0;j<n;j++){
                
                if(i!=j){
                    if(t.invalid(list.get(j))){
                        res.add(t.toString());
                        break;
                    }
                }
            }
        }
        return res;
    }

    class Transaction{
        String name;
        int time;
        int amt;
        String city;

        public Transaction(String name, int time, int amt, String city){
            this.name = name;
            this.time = time;
            this.amt = amt;
            this.city = city;
        }

        public boolean invalid(Transaction t){
            if(this.amt > 1000) return true;
            if(!this.name.equals(t.name)) return false;

            if(this.city.equals(t.city)) return false;

            return Math.abs(this.time - t.time) <= 60;
        }

        public String toString(){
            return name+","+time+","+amt+","+city;
        }
    }
}