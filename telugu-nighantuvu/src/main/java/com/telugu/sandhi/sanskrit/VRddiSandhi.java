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
public class VRddiSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu, boolean isTeluguScript) {
        if(isTeluguScript) {
            tokenString = ts.t(tokenString, "telugu", "hk");
        }
        String token = tokenString;

        // Lookup into possible values "ai", "au".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("ai", Arrays.asList("a", "A"), Arrays.asList("E", "ai")));
        possibleSeperatos.add(new SandhiSeperator("au", Arrays.asList("a", "A"), Arrays.asList("O", "au")));

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
