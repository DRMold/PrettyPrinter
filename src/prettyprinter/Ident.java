package prettyprinter;

import java.io.*;

class Ident extends Node 
{
  private String name;

  public Ident(String n) { name = n; }
  
  public boolean isSymbol() { return true; }

  public void print(int n) {
    for (int i = 0; i < n; i++)
      System.out.print(" ");

    System.out.println(name);
  }
}
