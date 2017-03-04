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
public class SchutvaSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu) {
        // TODO. Check with Telugu Expert and fill rest values.
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("cc", Arrays.asList("t"), Arrays.asList("c","S","s","sh")));
        possibleSeperatos.add(new SandhiSeperator("cC", Arrays.asList("t"), Arrays.asList("C","S","s","sh")));
        possibleSeperatos.add(new SandhiSeperator("jj", Arrays.asList("t"), Arrays.asList("j")));
        possibleSeperatos.add(new SandhiSeperator("ss", Arrays.asList("t"), Arrays.asList("s","s","sh")));


        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);
        // TODO. english to telugu translation is not working. fix this.
        return sandhiResponse;
    }
}
