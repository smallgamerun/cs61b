package deque;

public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
        /**
         * nextFirst和nextLast只要是相邻的即可，具体取值不影响
         */
    }

    private int addone(int x) {
        return (x + 1) % items.length;
    }

    private int minusone(int x) {
        return (x - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        int start=addone(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[start];
            start = addone(start);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    @Override
    public void addFirst(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusone(nextFirst);
        size++;
    }
    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = addone(nextLast);
        size++;
    }

    public void shrinksize() {
        if (isEmpty()) {
            resize(8);
        }
        if (items.length >= 16 && size < items.length / 4) {
            resize(size * 2);
        }
    }
    @Override
    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusone(nextLast);
        Item k = items[nextLast];
        items[nextLast] = null;
        size--;
        shrinksize();
        return k;
    }
    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = addone(nextFirst);
        Item k = items[nextFirst];
        items[nextFirst] = null;
        size--;
        shrinksize();
        return k;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i] + " ");
        }
        System.out.println();
    }
    @Override
    public Item get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(nextFirst+1+index)% items.length];
    }
    @Override
    //public boolean equals(ArrayDeque o)
    public boolean equals(Object l) {
        ArrayDeque<Item> o =(ArrayDeque<Item>) l;
        if (!(o instanceof ArrayDeque) || o.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (o.get(i) != items[(i+1+nextFirst)% items.length]) {
                return false;
            }
        }
        return true;
    }

}

