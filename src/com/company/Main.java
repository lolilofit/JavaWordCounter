package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
       InputStreamReader reader = null;
       OutputStreamWriter writer = null;
        try
        {
            reader = new InputStreamReader(new FileInputStream("C:\\Users\\User\\IdeaProjects\\untitled\\src\\in.csv"));
            writer = new OutputStreamWriter(new FileOutputStream("C:\\Users\\User\\IdeaProjects\\untitled\\src\\out.csv"));
        }
        catch (IOException e)
        {
            System.err.println("Can't open csv-file" + e.getLocalizedMessage());
        }

      Parser _pars = new Parser(reader);
      WordWriter _write = new WordWriter(writer);
      WordCount words_stat = new WordCount(_pars, _write);
      words_stat.count_words();
      writer.close();
    }

}
