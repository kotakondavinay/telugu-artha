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
public class ParasavarnaSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu) {

        // Lookup into possible values "lla", "llA".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("lla", Arrays.asList("t"), Arrays.asList("la")));
        possibleSeperatos.add(new SandhiSeperator("llA", Arrays.asList("t"), Arrays.asList("lA")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);

        return sandhiResponse;
    }
}
