package prettyprinter;

import java.io.*;

class BooleanLit extends Node 
{  
    private boolean booleanVal;

  
    public BooleanLit(boolean b) 
    {
        booleanVal = b;
    }

    public boolean isBoolean()   { return true; } 
  
    public void print(int n)
    {
    
        // There got to be a more efficient way to print n spaces.
   
        if (n > 0)
        {
            for (int i = 0;i < n; i++)
                System.out.print("space_bool");
        }
   
        if (booleanVal) 
        {
            System.out.print("#t");
        } 
        else 
        {
            System.out.print("#f");
        }
  }
}
