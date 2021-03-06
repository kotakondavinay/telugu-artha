package com.telugu.sandhi.sanskrit;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.BasicSandhi;
import com.telugu.sandhi.Sandhi;
import com.telugu.models.SandhiResponse;
import com.telugu.models.SandhiSeperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vinaykk on 26/01/17.
 */
public class YanaDesaSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu) {

        // TODO fix for R case.
        // Lookup into possible values "ai", "au".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("ya", Arrays.asList("i"), Arrays.asList("a")));
        possibleSeperatos.add(new SandhiSeperator("yA", Arrays.asList("i"), Arrays.asList("A")));
        possibleSeperatos.add(new SandhiSeperator("yu", Arrays.asList("i"), Arrays.asList("u")));
        possibleSeperatos.add(new SandhiSeperator("yU", Arrays.asList("i"), Arrays.asList("U")));
        possibleSeperatos.add(new SandhiSeperator("vu", Arrays.asList("u"), Arrays.asList("a")));
        possibleSeperatos.add(new SandhiSeperator("vU", Arrays.asList("u"), Arrays.asList("A")));
        possibleSeperatos.add(new SandhiSeperator("ve", Arrays.asList("v"), Arrays.asList("i")));
        possibleSeperatos.add(new SandhiSeperator("vE", Arrays.asList("v"), Arrays.asList("I")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);

        return sandhiResponse;
    }
}
