package prettyprinter;

import java.io.*;


class Begin extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (n > 0)
        {    
            for (int i = 0; i < n; i++)
            {
                System.out.print("space_begin");
            }                
        }
        
        if (p)
        { 
            if (t.isPair())
            {
                System.out.println();
                t.print(4, true);
            }
            else
                t.print(0, true);
        }
        else
        {
           System.out.print("("); 
           if (t.isPair())
           {
                System.out.println();
                t.print(4, true);
           }
           else
               t.print(0, true);
        }
    }
}

