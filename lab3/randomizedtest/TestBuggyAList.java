package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */


public class TestBuggyAList
{
    @Test
    public void testThreeAddThreeRemove()
    {
        BuggyAList<Integer> buggyAList=new BuggyAList<>();
        AListNoResizing<Integer> aListNoResizing=new AListNoResizing<>();
        buggyAList.addLast(4);
        aListNoResizing.addLast(4);
        buggyAList.addLast(5);
        aListNoResizing.addLast(5);
        buggyAList.addLast(6);
        aListNoResizing.addLast(6);
        assertEquals(buggyAList.size(),aListNoResizing.size());
        assertEquals(buggyAList.removeLast(),aListNoResizing.removeLast());
        assertEquals(buggyAList.removeLast(),aListNoResizing.removeLast());
        assertEquals(buggyAList.removeLast(),aListNoResizing.removeLast());
    }
    @Test
    public void ramdomizedTest()
    {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Bad=new BuggyAList<>();
        int N = 5000;
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
                int last=L.getLast();
                int badlast=Bad.getLast();
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

    public void main()
    {
        testThreeAddThreeRemove();
        ramdomizedTest();
    }
}
