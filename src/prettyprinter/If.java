package prettyprinter;
import java.io.*;

class If extends Special 
{
    void print(Node t, int n, boolean p)
    {
        if (p)
        {
            if (t.getCdr().getCdr() != null)
            {
                t.getCar().print(-n, true);
                System.out.println();
                t.getCdr().getCar().print(n+4, true);
                System.out.println();
                t.getCdr().getCdr().print(n+4, true);
                System.out.println();
            }
            else if (t.getCdr() != null)
            {
                t.getCar().print(-n, false);
                System.out.println();
                t.getCdr().print(n+4, true);
                System.out.println();
            }
            else
                System.err.print("NullPointer");
        }
        else
        {
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            System.out.print("(if ");
        }
   }
}
