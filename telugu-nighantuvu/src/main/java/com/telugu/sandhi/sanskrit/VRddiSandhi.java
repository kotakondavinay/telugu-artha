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

    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu) {

        // Lookup into possible values "ai", "au".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("ai", Arrays.asList("a", "A"), Arrays.asList("E", "ai")));
        possibleSeperatos.add(new SandhiSeperator("au", Arrays.asList("a", "A"), Arrays.asList("O", "au")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);
        return sandhiResponse;
    }
}
