package com.company;

import com.sun.org.apache.bcel.internal.generic.FLOAD;

import java.io.IOException;
import java.util.*;
import  java.io.*;

public class WordWriter {
    private OutputStreamWriter out;

    WordWriter(OutputStreamWriter _out) {
        out = _out;
    }


    void write(double count, Map<String, Integer> words) throws IOException {

        List<Map.Entry<String, Integer>> list = new ArrayList(words.entrySet());

          list.sort(Map.Entry.comparingByValue());
          Map<String, Integer> res = new LinkedHashMap<>();
          for(Map.Entry<String, Integer> entry : list) {
              res.put(entry.getKey(), entry.getValue());
          }

        for(Map.Entry<String, Integer> ent : res.entrySet()) {
            out.write(ent.getKey());
            out.write(" , ");
            out.write(ent.getValue().toString());
            out.write(" , ");
            Double val = new Double((ent.getValue())/count);
            out.write(val.toString());
            out.write("% \n");
        }
    }
}
