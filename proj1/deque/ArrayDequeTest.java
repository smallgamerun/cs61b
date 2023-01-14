package deque;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.functions.Innermost;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */


public class ArrayDequeTest
{
    @Test
    public void testThreeAddThreeRemove()
    {
        ArrayDeque<Integer> ArrayDeque=new ArrayDeque<>();
        LinkedListDeque<Integer> LinkedListDeque=new LinkedListDeque<>();
        ArrayDeque.addLast(4);
        LinkedListDeque.addLast(4);
        ArrayDeque.addLast(5);
        LinkedListDeque.addLast(5);
        ArrayDeque.addLast(6);
        LinkedListDeque.addLast(6);
        assertEquals(ArrayDeque.size(),LinkedListDeque.size());
        assertEquals(ArrayDeque.removeLast(),LinkedListDeque.removeLast());
        assertEquals(ArrayDeque.removeLast(),LinkedListDeque.removeLast());
        assertEquals(ArrayDeque.removeLast(),LinkedListDeque.removeLast());
    }
    @Test
    public void ramdomizedTest()
    {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> Bad=new ArrayDeque<>();
        int N = 700;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Bad.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                //System.out.println("size: " + size);
            }
            else if(operationNumber==2)
            {
                //getLast
                if(L.size()==0 || Bad.size()==0)
                {
                    continue;
                }
                int last=L.get(0);
                int badlast=Bad.get(0);
                assertEquals(last,badlast);
                //System.out.println("Last: "+last);
            }
            else if(operationNumber==3)
            {
                //removeLast
                if(L.size()==0 || Bad.size()==0)
                {
                    continue;
                }
                int last= L.removeLast();
                int badlast=Bad.removeLast();
                assertEquals(last,badlast);
                //System.out.println("removeLast("+last+")");
            }
        }
    }

    @Test
    public void iteratorTest()
    {
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<Integer>();
        arrayDeque.addLast(1);
        arrayDeque.addLast(4);
        arrayDeque.addLast(2);

    }

    public void main()
    {
        //testThreeAddThreeRemove();
        //ramdomizedTest();
        iteratorTest();
    }
}
