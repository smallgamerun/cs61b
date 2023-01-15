package deque;
import java.util.Iterator;
public class LinkedListDeque<T> implements Deque<T>,Iterable<T> {
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        private IntNode() {
            next = null;
            prev = null;
        }

        private IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private IntNode last;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode();
        last = new IntNode();
        size = 0;
        sentinel.next = last;
        last.prev = sentinel;
    }

    @Override
    public void addFirst(T x) {
        IntNode k = new IntNode(x, sentinel.next, sentinel);
        sentinel.next = k;
        k.next.prev = k;
        size++;
    }

    @Override
    public void addLast(T x) {
        IntNode k = new IntNode(x, last, last.prev);
        last.prev = k;
        k.prev.next = k;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != last) {
            System.out.println(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T rt = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return rt;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T rt = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        size--;
        return rt;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        IntNode p = sentinel;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.next.item;
    }

    /**
     * IntNode kp=sentinel;
     * public Item getRecursive(int index)
     * {
     * if(index>=size)
     * {
     * return null;
     * }
     * <p>
     * if(index==0)
     * {
     * return kp.next.item;
     * }
     * kp=kp.next;
     * return getRecursive(index-1);
     * }
     */

    private T helpFunctionOfgetRecursive(int index, IntNode p) {
        if (index == 0) {
            return p.next.item;
        }
        return helpFunctionOfgetRecursive(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return helpFunctionOfgetRecursive(index, sentinel);
    }

    @Override
    //public boolean equals(LinkedListDeque<Item> l)  -- wrong!
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }

        if (!(o instanceof Deque)) {
            return false;
        }
        /**
        if(getClass()!=o.getClass()){
            return false;
        }
         */
        Deque<T> l = (Deque<T>) o;
        if (size != l.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            /**
             IntNode a= this.sentinel.next;
             IntNode b=l.sentinel.next;
             if(a.item!= b.item)
             {
             return false;
             }
             a=a.next;
             b=b.next;
             */
            if (!(get(i).equals(l.get(i)))) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private IntNode p;

        LinkedListDequeIterator() {
            p = sentinel.next;
        }

        public boolean hasNext() {
            return p != last;
        }

        public T next() {
            T item = p.item;
            p = p.next;
            return item;
        }
    }
}


