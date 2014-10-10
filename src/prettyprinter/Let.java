package prettyprinter;
import java.io.*;

class Let extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (p)
        {
            t.print(n+4, true);
        }
        else
        {
            if (n > 0)
            {
                for (int i = 0; i < n; i++)
                    System.out.print(" ");
            }
            System.out.println("(let ");
        }
    }
}
