package prettyprinter;
import java.io.*;

class If extends Special 
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
            if (t.getCar() != null)
            {
                t.print(-n, false);
                t.print(n+4, true);
            }
            else 
                System.err.print("NULL");
        }
        else
            System.out.print("(if ");
   }
}
