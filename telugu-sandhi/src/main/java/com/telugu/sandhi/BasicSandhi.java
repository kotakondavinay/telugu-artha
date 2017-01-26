package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.models.SandhiResponse;
import com.telugu.sandhi.models.SandhiSeperator;
import com.telugu.telscript.TeluguScript;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinaykk on 26/01/17.
 */
public class BasicSandhi {

    protected TeluguScript ts = new TeluguScript();

    public SandhiResponse isSandhi(String processedToken,
                                   SandhiSeperator sandhiSeperator, Nighantuvu nighantuvu) {
        String[] split = processedToken.split(sandhiSeperator.getSeperator());
        for(int i = 0 ; i < split.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i ; j++) {
                sb.append(split[j]).append(sandhiSeperator.getSeperator());
            }
            sb.append(split[i]);
            String splitFirstPart = sb.toString();
            sb = new StringBuilder();
            for( int j = i+1; j < split.length - 1; j++) {
                sb.append(split[j]).append(sandhiSeperator.getSeperator());
            }
            sb.append(split[split.length-1]);
            String splitSecondPart = sb.toString();

            List<String> firstPartValues = new ArrayList<String>();
            for(String firstPartSuffix: sandhiSeperator.getFirstPartSuffixes()) {
                firstPartValues.add(splitFirstPart + firstPartSuffix);
            }
            List<String> secondPartValues = new ArrayList<String>();
            for(String secondPartPrefix: sandhiSeperator.getSecondPartPrefixes()) {
                secondPartValues.add(secondPartPrefix + splitSecondPart );
            }
            for(String firstPart: firstPartValues) {
                for(String secondPart: secondPartValues) {
                    if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart)) {
                        return new SandhiResponse(true, firstPart, secondPart);
                    }
                }
            }
        }
        return new SandhiResponse(false);
    }

    public SandhiResponse isSandhi(String processedToken,
                                   List<SandhiSeperator> sandhiSeperators, Nighantuvu nighantuvu) {

        for(SandhiSeperator sandhiSeperator: sandhiSeperators) {
            SandhiResponse sandhiResponse = isSandhi(processedToken, sandhiSeperator, nighantuvu);
            if(sandhiResponse.isSandhi()) {
                return sandhiResponse;
            }
        }
        return new SandhiResponse(false);
    }
}
