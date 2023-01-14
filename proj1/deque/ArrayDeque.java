package deque;
import java.util.Iterator;
public class ArrayDeque<T> implements Deque<T>,Iterable<T> {
    @SuppressWarnings("unchecked")
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
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
        T[] a = (T[]) new Object[capacity];
        int start = addone(nextFirst);
        for (int i = 0; i < size; i++) {
            a[i] = items[start];
            start = addone(start);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = minusone(nextFirst);
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = addone(nextLast);
        size++;
    }

    private void shrinksize() {
        if (isEmpty()) {
            resize(8);
        }
        if (items.length >= 16 && size < items.length / 4) {
            resize(size * 2);
        }
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = minusone(nextLast);
        T k = items[nextLast];
        items[nextLast] = null;
        size--;
        shrinksize();
        return k;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = addone(nextFirst);
        T k = items[nextFirst];
        items[nextFirst] = null;
        size--;
        shrinksize();
        return k;
    }

    @SuppressWarnings("unchecked")
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
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(nextFirst + 1 + index) % items.length];
    }

    @Override
    //public boolean equals(ArrayDeque o)
    public boolean equals(Object l) {
        if (l == null) {
            return false;
        }
        if (l == this) {
            return true;
        }
        /**
        if (!(l instanceof ArrayDeque)) {
            return false;
        }
         */
        if(l.getClass()!=getClass()){
            return false;
        }
        ArrayDeque<?> o = (ArrayDeque<?>) l;
        if (o.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {

            if (o.get(i) != get(i))/*items[(i+1+nextFirst)% items.length]*/ {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        ArrayDequeIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            T item = get(index);
            index += 1;
            return item;
        }
    }

}

