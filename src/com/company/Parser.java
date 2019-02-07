package com.company;
import java.io.*;
import  java.lang.*;
import static java.lang.Character.isLetterOrDigit;

public class Parser implements  ParcerInterface {
   private InputStreamReader in;
   Parser(InputStreamReader _in) {
       in = _in;
   }

   @Override
   public String read_word() throws IOException {
       boolean first = false;
       StringBuilder word = new StringBuilder();
       int symb;
       char ch;

       try {
           while ((symb = in.read()) != -1) {
               ch = (char) symb;
               if ((ch >= '0') && (ch <= '9') || isLetterOrDigit(ch)) {
                    if(first == false) {
                        first = true;
                        word.insert(0, ch);
                    }
                    else
                      word.append(ch);
               }
               else {
                   if(word.toString().isEmpty() && (ch == '\n'))
                       word.insert(0, " ");
                   return word.toString();
               }

           }
       }
       finally {
           //if(in != null) in.close();
       }
       return word.toString();
   }

}
