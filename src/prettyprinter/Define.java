package prettyprinter;

import java.io.*;

class Define extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (n > 0)
        {    
            for (int i = 0; i < n; i++)
            {
                System.out.print("space_define");
            }                
        }
        
        if (p)
        { 
            if (t.isPair())
            {
                if (t.getCar().isPair())
                {
                    t.print(4, true);
                }
                else 
                    t.print(0, true);
            }
            else
                t.print(0, true);
        }
        else
        {
           System.out.print("("); 
           if (t.isPair())
           {
                if (t.getCar().isPair())
                {
                    t.print(n, true);
                }
                else
                    t.print(0, true);
           }
           else
               t.print(0, true);
        }
    }
}
