public interface Deque<Item> {
    public void addFirst(Item item);
    public void addLast(Item item);
    public boolean isEmpty();
    public Item removeFirst();
    public Item removeLast();
    public Item getIndex(int i);
    public int size();
}
