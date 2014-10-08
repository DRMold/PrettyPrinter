package prettyprinter;

import java.io.*;

class Regular extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (n > 0)
        {    
            for (int i = 0; i < n; i++)
            {
                System.out.print("space_reg");
            }                
        }
        
        if (p)
        {
             if (t.isPair() || t.isNull())
                t.print(0, true);
             else
                 t.print(1);
        }
        else
        {
           System.out.print("("); 
           if (t.isPair() || t.isNull())
            t.print(0, true);
           else
               t.print(0);
        }
    }
}
