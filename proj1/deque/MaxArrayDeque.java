package deque;

import java.util.Comparator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item>{
    public Comparator <Item> comparator;
    public MaxArrayDeque(Comparator<Item> c)
    {
        super();
        comparator=c;
    }

    public Item max()
    {
        /**
        if(isEmpty())
        {
            return null;
        }
        int maxindex=0;
        for(int i=0;i<size();i++)
        {
            if(comparator.compare(get(i),get(maxindex))>0)
            {
                maxindex=i;
            }
        }
        return get(maxindex);
         */
        return max(comparator);
    }

    public Item max(Comparator<Item> c)
    {
        if(isEmpty())
        {
            return null;
        }
        int maxindex=0;
        for(int i=0;i<size();i++)
        {
            if(c.compare(get(i),get(maxindex))>0)
            {
                maxindex=i;
            }
        }
        return get(maxindex);
    }
}
