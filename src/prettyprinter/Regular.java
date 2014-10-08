package prettyprinter;

import java.io.*;

class Regular extends Special 
{
    void print(Node t, int n, boolean p) 
    {
        if (p)
        {
            t.print(1, true); }
        else
        {
            System.out.print("(");
            t.print(n-n, true);
        }
    }
}
