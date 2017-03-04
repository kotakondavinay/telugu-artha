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
public class GuNaSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu) {
        String token = tokenString.replace("ea", "E").replace("oe", "O");

        // Lookup into possible values "A", "I", "U",
        // TODO . for RR
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("E", Arrays.asList("a", "A"), Arrays.asList("i", "I")));
        possibleSeperatos.add(new SandhiSeperator("O", Arrays.asList("a", "A"), Arrays.asList("u", "U")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);
        return sandhiResponse;
    }
}
