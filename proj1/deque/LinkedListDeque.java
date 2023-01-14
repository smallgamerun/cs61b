package deque;

public class LinkedListDeque<Item> implements Deque<Item>
{
    private class IntNode
    {
        public Item item;
        public IntNode next;
        public IntNode prev;
        public IntNode()
        {
            next=null;
            prev=null;
        }
        public IntNode(Item i,IntNode n,IntNode p)
        {
            item=i;
            next=n;
            prev=p;
        }
    }
    private IntNode sentinel;
    private IntNode last;
    private int size;

    public LinkedListDeque()
    {
        sentinel=new IntNode();
        last=new IntNode();
        size=0;
        sentinel.next=last;
        last.prev=sentinel;
    }
    @Override
    public void addFirst(Item x)
    {
        IntNode k=new IntNode(x,sentinel.next,sentinel);
        sentinel.next=k;
        k.next.prev=k;
        size++;
    }
    @Override
    public void addLast(Item x)
    {
        IntNode k=new IntNode(x,last,last.prev);
        last.prev=k;
        k.prev.next=k;
        size++;
    }

    @Override
    public int size()
    {
        return size;
    }
    @Override
    public void printDeque()
    {
        IntNode p=sentinel;
        while(p.next!=last)
        {
            System.out.println(p.next.item+" ");
            p=p.next;
        }
        System.out.println();
    }
    @Override
    public Item removeFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        Item rt=sentinel.next.item;
        sentinel.next=sentinel.next.next;
        sentinel.next.prev=sentinel;
        size--;
        return rt;
    }
    @Override
    public Item removeLast()
    {
        if(isEmpty())
        {
            return null;
        }
        Item rt=last.prev.item;
        last.prev=last.prev.prev;
        last.prev.next=last;
        size--;
        return rt;
    }
    @Override
    public Item get(int index)
    {
        if(index>=size)
        {
            return null;
        }
        IntNode p=sentinel;
        while(index!=0)
        {
            p=p.next;
            index--;
        }
        return p.next.item;
    }
/**
    IntNode kp=sentinel;
    public Item getRecursive(int index)
    {
        if(index>=size)
        {
            return null;
        }

        if(index==0)
        {
            return kp.next.item;
        }
        kp=kp.next;
        return getRecursive(index-1);
    }
 */

    private Item helpFunctionOfgetRecursive(int index,IntNode p)
    {
        if(index==0)
        {
            return p.next.item;
        }
        return helpFunctionOfgetRecursive(index-1,p.next);
    }

    public Item getRecursive(int index)
    {
        if(index>=size || index<0)
        {
            return null;
        }
        return helpFunctionOfgetRecursive(index,sentinel);
    }

    @Override
    //public boolean equals(LinkedListDeque<Item> l)  -- wrong!
    public boolean equals(Object o)
    {
        LinkedListDeque<Item> l=(LinkedListDeque<Item>) o;
        if(!(l instanceof LinkedListDeque) || size!=l.size())
        {
            return false;
        }
        for(int i=0;i<size;i++)
        {
            IntNode a= this.sentinel.next;
            IntNode b=l.sentinel.next;
            if(a.item!= b.item)
            {
                return false;
            }
            a=a.next;
            b=b.next;
        }
        return true;
    }

}


