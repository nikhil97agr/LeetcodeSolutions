class BrowserHistory {
    int backInd = 0;
    int forwInd = 0;
    List<String> history;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>(); 
        history.add(homepage);     
    }
    
    public void visit(String url) {
        if(backInd == history.size()-1){
            history.add(url);
        }else{
            history.set(backInd+1, url);
        }

        backInd++;
        forwInd = backInd;
    }
    
    public String back(int steps) {
        int urlInd = Math.max(0, backInd - steps);
        backInd = urlInd;
        return history.get(backInd);
    }
    
    public String forward(int steps) {
        int urlInd = Math.min(forwInd, backInd+steps);
        backInd = urlInd;
        return history.get(backInd);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */