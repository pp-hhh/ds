public class ArrayDeque<Item> implements Deque<Item>{
    private int size;
    private Item[] items;
    private int nextFirst = 3;
    private int nextLast = 4;
    private final int REFACTOR = 2;

    public ArrayDeque() {
        size = 0;
        items = (Item[])new Object[8];
    }

    public int addOne(int x) {
        return (x + 1)%items.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(Item item) {
        if (items.length == size) {
            resize();
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        }else{
            nextFirst -= 1;
        }
        size += 1;
    }

    @Override
    public void addLast(Item item) {
        if (items.length == size) {
            resize();
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        }else {
            nextLast += 1;
        }
        size += 1;
    }

    @Override
    public Item removeFirst() {
        /*特殊情况要考虑*/
        if (size == 0){
            return null;
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        }else {
            nextFirst += 1;
        }
        size -= 1;
        return items[nextFirst];
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (nextLast == 0) {
            nextLast = items.length - 1;
        }else {
            nextLast -= 1;
        }
        size -= 1;
        return items[nextLast];
    }

    @Override
    public Item getIndex(int index) {
        if (index >= size) {
            return null;
        }
        return items[index];
    }

    @Override
    public int size() {
        return size;
    }

    public void resize() {
        Item[] temp = (Item[]) new Object[size*REFACTOR];
        //System.arraycopy(items,0,temp,0,size); 未考虑到items会从尾部回到头部
        for(int i = 0; i < size; i++) {
            nextFirst = addOne(nextFirst);
            temp[i] = items[nextFirst];
        }
        items = temp;
        //最方便的情况
        nextFirst = items.length - 1;
        nextLast = size;
    }
}
