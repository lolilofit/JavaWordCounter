package com.company;
import java.io.IOException;
import java.util.*;

public class WordCount implements  CountWordsInterface{
    private Map<String, Integer> words;
    private Parser pars;
    private WordWriter write_stat;
    private double count;

    WordCount(Parser _pars, WordWriter _write) {
        pars = _pars;
        write_stat= _write;
        words = new HashMap<>();
        count = 0;
    }

    @Override
    public void count_words() throws IOException {
        String word;

        while(((word = pars.read_word()).isEmpty()) == false) {
            Integer f = words.get(word);
            if(word.equals(" ") == false) {
                if (f == null)
                    words.put(word, 1);
                else
                    words.put(word, words.get(word) + 1);

                count++;
            }
        }

        write_stat.write(count, words);
    }
}
