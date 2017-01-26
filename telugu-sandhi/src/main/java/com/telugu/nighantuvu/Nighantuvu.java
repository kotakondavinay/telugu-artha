package com.telugu.nighantuvu;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vinaykk on 22/01/17.
 */
public class Nighantuvu {
    public Set<String> words;

    public Nighantuvu() {
        words = new HashSet<String>();
        words.add("deva");
        words.add("aalayam");
        words.add("raama");
        words.add("rAma");
        words.add("shiva");
        words.add("hima");
        words.add("adri");
    }

    public boolean contains(String token) {
        return words.contains(token);
    }
}
