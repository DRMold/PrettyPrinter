package prettyprinter;

import java.io.*;


class Begin extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (p)
        {
            printBegin(t, n);
        }
        else
        {
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            System.out.println("(begin ");
        }
    }
    
    private void printBegin(Node t, int n)
    {
        if (t.getCdr().isNull())
        {
            t.getCar().print(n+4, false);
            System.out.println();
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            t.getCdr().print(n+4, true);
            return;
        }
        t.getCar().print(n+4, false);
        System.out.println();
        printBegin(t.getCdr(), n);
    }
}

