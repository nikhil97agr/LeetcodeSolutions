class FrequencyTracker {
    int cnt[] = new int[100001];
    int freq[] = new int[100001];
    public FrequencyTracker() {
        
    }
    
    public void add(int number) {
        int prev = cnt[number];
        freq[prev]--;
        cnt[number]++;
        freq[prev+1]++;
    }
    
    public void deleteOne(int number) {
        int prev = cnt[number];
        if(prev ==0) return;
        freq[prev]--;
        cnt[number]--;
        freq[prev-1]++;
    }
    
    public boolean hasFrequency(int frequency) {
        return freq[frequency]!=0;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */