class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iter = iterator;
        if (this.iter.hasNext()) {
            this.nextVal = this.iter.next();
        }
    }
    
    public Integer peek() {
        return nextVal;
    }
    
    @Override
    public Integer next() {
        Integer current = nextVal;
        nextVal = iter.hasNext() ? iter.next() : null;
        return current;
    }
    
    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}
