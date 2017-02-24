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
public class VisargaSandhi extends BasicSandhi {
    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu, boolean isTeluguScript) {
        if(isTeluguScript) {
            tokenString = ts.t(tokenString, "telugu", "hk");
        }
        String token = tokenString;

        // First Rule.
        //
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("Oa", Arrays.asList("aH"), Arrays.asList("a")));
        possibleSeperatos.add(new SandhiSeperator("Og", Arrays.asList("aH"), Arrays.asList("g")));
        possibleSeperatos.add(new SandhiSeperator("Ogh", Arrays.asList("aH"), Arrays.asList("gh")));
        possibleSeperatos.add(new SandhiSeperator("Oj", Arrays.asList("aH"), Arrays.asList("j")));
        possibleSeperatos.add(new SandhiSeperator("Ojh", Arrays.asList("aH"), Arrays.asList("jh")));
        possibleSeperatos.add(new SandhiSeperator("OD", Arrays.asList("aH"), Arrays.asList("D")));
        possibleSeperatos.add(new SandhiSeperator("ODh", Arrays.asList("aH"), Arrays.asList("Dh")));
        possibleSeperatos.add(new SandhiSeperator("Od", Arrays.asList("aH"), Arrays.asList("d")));
        possibleSeperatos.add(new SandhiSeperator("Odh", Arrays.asList("aH"), Arrays.asList("dh")));
        possibleSeperatos.add(new SandhiSeperator("On", Arrays.asList("aH"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("Ob", Arrays.asList("aH"), Arrays.asList("b")));
        possibleSeperatos.add(new SandhiSeperator("Obh", Arrays.asList("aH"), Arrays.asList("bh")));
        possibleSeperatos.add(new SandhiSeperator("Om", Arrays.asList("aH"), Arrays.asList("m")));
        possibleSeperatos.add(new SandhiSeperator("Oy", Arrays.asList("aH"), Arrays.asList("y")));
        possibleSeperatos.add(new SandhiSeperator("Or", Arrays.asList("aH"), Arrays.asList("r")));
        possibleSeperatos.add(new SandhiSeperator("Ol", Arrays.asList("aH"), Arrays.asList("l")));
        possibleSeperatos.add(new SandhiSeperator("Ov", Arrays.asList("aH"), Arrays.asList("v")));

        //Second Rule.
        possibleSeperatos.add(new SandhiSeperator("SS", Arrays.asList("H"), Arrays.asList("S")));
        possibleSeperatos.add(new SandhiSeperator("shsh", Arrays.asList("H"), Arrays.asList("sh")));
        possibleSeperatos.add(new SandhiSeperator("ss", Arrays.asList("H"), Arrays.asList("s")));

        //Third Rule.
        possibleSeperatos.add(new SandhiSeperator("aHk", Arrays.asList("aH"), Arrays.asList("k")));
        possibleSeperatos.add(new SandhiSeperator("aHkh", Arrays.asList("aH"), Arrays.asList("kh")));
        possibleSeperatos.add(new SandhiSeperator("aHp", Arrays.asList("aH"), Arrays.asList("p")));
        possibleSeperatos.add(new SandhiSeperator("aHph", Arrays.asList("aH"), Arrays.asList("ph")));

        //Fourth Rule.
        possibleSeperatos.add(new SandhiSeperator("Sc", Arrays.asList("H"), Arrays.asList("c")));
        possibleSeperatos.add(new SandhiSeperator("Sch", Arrays.asList("H"), Arrays.asList("ch")));
        possibleSeperatos.add(new SandhiSeperator("shT", Arrays.asList("H"), Arrays.asList("T")));
        possibleSeperatos.add(new SandhiSeperator("shTh", Arrays.asList("H"), Arrays.asList("Th")));
        possibleSeperatos.add(new SandhiSeperator("st", Arrays.asList("H"), Arrays.asList("t")));
        possibleSeperatos.add(new SandhiSeperator("sth", Arrays.asList("H"), Arrays.asList("th")));

        //Fifth Rule.
        //TODO. Check with Telugu expert.

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
