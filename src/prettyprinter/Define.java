package prettyprinter;

import java.io.*;

class Define extends Special 
{
    private boolean isFunc;
    
    private void ifFunc(Node t)
    {
        if (t.getCar().isPair())
            isFunc = true;
    }
    
    void print(Node t, int n, boolean p) 
    {
        if (p)
        {
            this.ifFunc(t);
            if (isFunc)
            {
                if (t.getCdr() != null)
                {
                    t.getCar().print(-n, false);
                    System.out.println();
                    printDefine(t.getCdr(), n);
                }
                else
                    System.err.print("NullPointer");
            }
            else
            { t.print(n, p); }
        }
        else
        {
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            System.out.print("(define ");
        }
    }
    
    private void printDefine(Node t, int n)
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
        printDefine(t.getCdr(), n);
    }
}
