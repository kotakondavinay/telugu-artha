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
public class AnunasikaSandhi extends BasicSandhi {

    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu) {

        //Anunasikas are G, J, N, n, m
        // Lookup into possible values "Gm", "Jm", "Nm", "nm", "mm", "Gn", "Jn", "Nn", "nn", "mn".
        List<SandhiSeperator> possibleSeperatos = new ArrayList<SandhiSeperator>();
        possibleSeperatos.add(new SandhiSeperator("Gn", Arrays.asList("k"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("Jn", Arrays.asList("c"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("Nn", Arrays.asList("T"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("nn", Arrays.asList("t"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("mn", Arrays.asList("p"), Arrays.asList("n")));
        possibleSeperatos.add(new SandhiSeperator("Gm", Arrays.asList("k"), Arrays.asList("m")));
        possibleSeperatos.add(new SandhiSeperator("Jm", Arrays.asList("c"), Arrays.asList("m")));
        possibleSeperatos.add(new SandhiSeperator("Nm", Arrays.asList("T"), Arrays.asList("m")));
        possibleSeperatos.add(new SandhiSeperator("nm", Arrays.asList("t"), Arrays.asList("m")));
        possibleSeperatos.add(new SandhiSeperator("mm", Arrays.asList("p"), Arrays.asList("m")));

        SandhiResponse sandhiResponse = isSandhi(token, possibleSeperatos, nighantuvu);
        return sandhiResponse;
    }
}
