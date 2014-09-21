package prettyprinter;
// Scanner.java -- the implementation of class Scanner

import java.io.*;

class Scanner 
{
  private PushbackInputStream in;
  private byte[] buf = new byte[1000];

  public Scanner(InputStream i) { in = new PushbackInputStream(i); }
    
  public Token getNextToken()
  {
    int bite = -1;
	
    // It would be more efficient if we'd maintain our own input buffer
    // and read characters out of that buffer, but reading individual
    // characters from the input stream is easier.
    try {
      bite = in.read();
    } catch (IOException e) {
      System.err.println("We fail: " + e.getMessage());
    }
    
    //Removes whitespace and comments
    if (bite >= 0 && bite <= 32) 
        bite = -1;
    if (bite == 59) 
    {
       do 
       {
           try {
                in.read();
           } catch (IOException e) {
                System.err.println("We fail: " + e.getMessage());
           }
       } while (bite != 10); //Looks for newline
       bite = -1;
    }
        
    
    if (bite == -1)
      return null;

    char ch = (char) bite;
	
    // Special characters
    if (ch == '\'')
      return new Token(Token.QUOTE);
    else if (ch == '(')
      return new Token(Token.LPAREN);
    else if (ch == ')')
      return new Token(Token.RPAREN);
    else if (ch == '.')
      // We ignore the special identifier `...'.
      return new Token(Token.DOT);

    // Boolean constants
    else if (ch == '#') {
      try {
	bite = in.read();
      } catch (IOException e) {
	System.err.println("We fail: " + e.getMessage());
      }

      if (bite == -1) {
	System.err.println("Unexpected EOF following #");
	return null;
      }
      ch = (char) bite;
      if (ch == 't')
	return new Token(Token.TRUE);
      else if (ch == 'f')
	return new Token(Token.FALSE);
      else {
	System.err.println("Illegal character '" + (char) ch + "' following #");
	return getNextToken();
      }
    }

    // String constants
    else if (ch == '"') {
      int i = 0;
      do
      {
        try {
            bite = in.read();
        } catch (IOException e) {
            System.err.println("We fail: " + e.getMessage());
        } 
        buf[i] = (byte) bite;
        i++;
      } while (bite != 34); 

      return new StrToken(new String(buf)); //buf.toString()
    }

    // Integer constants
    else if (ch >= '0' && ch <= '9') 
    {
      int i = ch - '0';
      // TODO: scan the number and convert it to an integer
      // put the character after the integer back into the input
      // in->putback(ch);
      do
      {
          try {
            bite = in.read();
          } catch (IOException e) {
             System.err.println("We fail: " + e.getMessage());
          } 
          if (bite >= 48 && bite <= 57)
            i = (i * 10) + (bite - 48);
          else break;         
      } while (true);
      try {
          in.unread(bite);
      } catch (IOException e) {
         System.err.println("We fail: " + e.getMessage());
      } 
      return new IntToken(i);
    }

    // Identifiers
    else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || 
            (ch >= '$' && ch <= '&') || (ch >= '<' && ch <= '@') || 
            ch == '!' || ch == '+' || ch == '*' || ch == '-' || 
            ch == '/' || ch == ':' || ch == '^' || ch == '_' || ch == '~') 
    {
      // TODO: scan an identifier into the buffer
      // put the character after the identifier back into the input
      // in->putback(ch);
      int i = 0;
      do {
          try {
            bite = in.read();
          } catch (IOException e) {
             System.err.println("We fail: " + e.getMessage());
          } 
          buf[i] = (byte) bite;
          i++;
      } while (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || 
            (ch >= '$' && ch <= '&') || (ch >= '<' && ch <= '@') || 
            ch == '!' || ch == '+' || ch == '*' || ch == '-' || 
            ch == '/' || ch == ':' || ch == '^' || ch == '_' || ch == '~'));
                
      try {
          in.unread(bite);
      } catch (IOException e) {
         System.err.println("We fail: " + e.getMessage());
      } 
      return new IdentToken(new String(buf)); //buf.toString()
    }

    // Illegal character
    else 
    {
      System.err.println("Illegal input character '" + (char) ch + '\'');
      return getNextToken();
    }
  };
}
