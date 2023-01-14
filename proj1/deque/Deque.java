package deque;

public interface Deque<T> {
    void addFirst(T x);
    void addLast(T x);
    int size();
    void printDeque();
    T removeFirst();
    T removeLast();
    T get(int index);

    boolean equals(Object o);

    default Boolean isEmpty(){
        return size()==0;
    }
}
