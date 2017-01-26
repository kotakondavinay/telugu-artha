package com.telugu.sandhi.sanskrit;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.BasicSandhi;
import com.telugu.sandhi.Sandhi;
import com.telugu.sandhi.models.SandhiResponse;
import com.telugu.sandhi.models.SandhiSeperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vinaykk on 26/01/17.
 */
public class SavarnaDheergaSandhi extends BasicSandhi implements Sandhi {

    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu, boolean isTeluguScript) {
        if(isTeluguScript) {
            tokenString = ts.t(tokenString, "telugu", "hk");
        }
        String token  = tokenString.replace("aa" , "A").replace("ee", "I").replace("uu", "U").replace("oo", "U");

        // Lookup into possible values "A", "I", "U",
        // TODO . for RR
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("A", Arrays.asList("a"), Arrays.asList("a", "A", "aa")));
        possibleSeperatos.add(new SandhiSeperator("I", Arrays.asList("i"), Arrays.asList("i", "I", "ee")));
        possibleSeperatos.add(new SandhiSeperator("U", Arrays.asList("U"), Arrays.asList("u", "U", "uu")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);
        // TODO. english to telugu translation is not working. fix this.
        if(isTeluguScript) {
            if(sandhiResponse.isSandhi()) {
                //String firstPart = sandhiResponse.getFirstPart();
                //sandhiResponse.setFirstPart(ts.t(firstPart, "hk", "telugu"));
                //String secondPart = sandhiResponse.getFirstPart();
                //sandhiResponse.setSecondPart(ts.t(secondPart, "hk", "telugu"));
            }
        }
        return sandhiResponse;
    }
}
