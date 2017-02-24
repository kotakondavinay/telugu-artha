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
        /** Added for SavaranaDheerga Sandhi */

        words.add("deva");
        words.add("aalayaM");
        words.add("rAma");
        words.add("shiva");
        words.add("hima");
        words.add("adri");

        /** Added for GunaSandhi Validation */
        words.add("mahA");
        words.add("utsavaM");

        /** Added for Anunasika Sandhi */
        words.add("jagat");
        words.add("nivAsaM");
        words.add("nATakaM");

        /** Added for vRddi Sandhi */
        words.add("Eka");
        words.add("aiSvaryamu");

        /** Added for YanaDesa Sandhi */
        words.add("prati");
        words.add("akshamu");
        words.add("gauri");
        words.add("ArAdhanaM");

        /** Added for Parasa varna Sandhi */
        words.add("vidyut");
        words.add("lata");

        /** Added for Schuthva Sandhi */
        words.add("sat");
        words.add("janulu");
        words.add("Sakti");

        /** Added for Visarga Sandhi */
        words.add("SiraH");
        words.add("vEdana");
        words.add("catuH");
        words.add("shashTi");

    }

    public boolean contains(String word) {
        return words.contains(word);
    }

    public void add(String word) {
        words.add(word);
    }

    public void delete(String word) {
        words.remove(word);
    }

    public Set<String> getWords(){ return words; }
}
