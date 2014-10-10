package prettyprinter;

import java.io.*;

class Regular extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (p)
        {
            t.print(n, true);
        }
        else
        {
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            System.out.print("(");
            if (t.isPair())
            {
                t.getCar().print(n, true);
                t.getCdr().print(n, true);
                System.out.println();
            }
            else
                t.print(-n, true);
            //System.out.println();
        }
    }
}
