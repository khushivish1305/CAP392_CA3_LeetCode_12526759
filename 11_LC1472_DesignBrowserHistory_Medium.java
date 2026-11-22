class BrowserHistory {
    private List<String> history;
    private int curr;
    private int end;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        end = 0;
    }
    
    public void visit(String url) {
        curr++;
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        end = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(end, curr + steps);
        return history.get(curr);
    }
}
