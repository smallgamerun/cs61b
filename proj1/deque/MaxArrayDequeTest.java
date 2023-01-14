package deque;

import org.junit.Test;

import java.util.Comparator;

public class MaxArrayDequeTest {

    private static class IntComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }
/**
    private static class StringComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }
 */
    @Test
    public void test1()
    {
        MaxArrayDeque<Integer> maxArrayDeque=new MaxArrayDeque<>(new IntComparator());
        maxArrayDeque.addLast(5);
        maxArrayDeque.addLast(10);
        maxArrayDeque.addLast(-3);
        org.junit.Assert.assertTrue(10== maxArrayDeque.max());
        //org.junit.Assert.assertEquals((Integer) 10,maxArrayDeque.max());
    }

    public void main(String[] args)
    {
        test1();
    }
}
