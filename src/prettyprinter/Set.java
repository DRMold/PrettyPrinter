package prettyprinter;
import java.io.*;

class Set extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (n > 0)
        {
            for (int i = 0; i < n; i++)
                System.out.print(" ");
        }
        
        if (p)
        {
            t.getCar().print(n, true);
            if (t.getCdr().isPair() && (t.getCdr().getCdr() != null))
            {
                System.out.print(" ");
                t.getCdr().getCar().print(n);
                t.getCdr().getCdr().print(n, true);
            }
            else if (!t.getCdr().isPair())
            {
                System.out.print(" ");
                t.getCdr().print(n,true);
            }
            else
                System.err.print(p);
        }
        else
        {
            System.out.print("(set ");
        }
    }
}
