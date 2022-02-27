public interface Deque <T>{
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    public T removeFirst();
    public T removeLast();
    public T getIndex(int i);
    public int size();
}
