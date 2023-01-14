package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator <T> comparator;
    public MaxArrayDeque(Comparator<T> c)
    {
        super();
        comparator=c;
    }

    public T max()
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

    public T max(Comparator<T> c)
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
