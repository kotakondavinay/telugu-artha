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
public class ParasavarnaSandhi extends BasicSandhi implements Sandhi {
    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu, boolean isTeluguScript) {
        if(isTeluguScript) {
            tokenString = ts.t(tokenString, "telugu", "hk");
        }
        String token = tokenString;

        // Lookup into possible values "ai", "au".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("lla", Arrays.asList("t"), Arrays.asList("la")));
        possibleSeperatos.add(new SandhiSeperator("llA", Arrays.asList("t"), Arrays.asList("lA")));

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
