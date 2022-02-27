public class LinkedListDeque<Item> implements Deque<Item>{
    private class StuffNode{
        public Item item;
        public StuffNode next;
        public StuffNode pre;

        public StuffNode(Item i, StuffNode n, StuffNode p){
            item = i;
            next = n;
            pre = p;
        }
    }

    private StuffNode sentinel;
    private int size;


    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item item) {
        sentinel.next.pre = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next = sentinel.next.pre;
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        sentinel.pre.next = new StuffNode(item, sentinel, sentinel.pre);
        sentinel.pre = sentinel.pre.next;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode temp = sentinel.next;
        for(int i = 0; i < size; i++) {
            System.out.println(temp.item);
        }
    }

    @Override
    public Item removeFirst() {
        Item temp = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -= 1;
        return temp;
    }

    @Override
    public Item removeLast() {
        Item temp = sentinel.pre.item;
        sentinel.pre = sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -= 1;
        return temp;
    }

    @Override
    public Item getIndex(int index) {
        StuffNode temp = sentinel.next;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public Item getRecursive(int index) {
        StuffNode temp = sentinel.next;
        if (index == 0) {
            return temp.item;
        }
        return getRecursive(index-1);
    }

}