package prettyprinter;
import java.io.*;

class Quote extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (n > 0)
        {    
            for (int i = 0; i < n; i++)
            {
                System.out.print("space_quote");
            }                
        }
        
        if (p)
        { 
            if (t.isPair() || t.isNull())
                t.print(0, true);
            else
                System.out.print("'");
        }
        else
        {
           if (t.isPair() || t.isNull())
            t.print(0, true);
           else
               System.out.print("'");
        }
    }
}
