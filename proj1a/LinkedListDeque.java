public class LinkedListDeque<T> {
    private class StuffNode{
        public T item;
        public StuffNode next;
        public StuffNode pre;

        public StuffNode(T i, StuffNode n, StuffNode p){
            item = i;
            next = n;
            pre = p;
        }
    }

    private StuffNode sentinel;
    private int size;

    LinkedListDequeTest<T> LinkedListDeque = new LinkedListDequeTest<T>();

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next.pre = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.pre;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.pre.next = new StuffNode(item, sentinel, sentinel.pre);
        sentinel.pre = sentinel.pre.next;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode temp = sentinel.next;
        for(int i = 0; i < size; i++) {
            System.out.println(temp.item);
        }
    }

    public T removeFirst() {
        T temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;
        return temp;
    }

    public T removeLast() {
        T temp = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -= 1;
        return temp;
    }

    public T getIndex(int index) {
        StuffNode temp = sentinel.next;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public T getRecursive(int index) {
        StuffNode temp = sentinel.next;
        if (index == 0) {
            return temp.item;
        }
        return getRecursive(index-1);
    }

}