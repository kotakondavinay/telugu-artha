package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.models.SandhiResponse;

/**
 * Created by vinaykk on 22/01/17.
 */
public class Sandhi {
    private Nighantuvu nighantuvu;

    public Sandhi() {
        this.nighantuvu = new Nighantuvu();
    }

    public SandhiResponse isSandhi(String token) {
        if(token.contains("aa")) {
            String[] split = token.split("aa");
            String firstPart = split[0]+"a";
            String secondPart1 = "a" + split[1];
            String secondPart2 = "aa" + split[1];
            if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart1)) {
                return new SandhiResponse(true, firstPart, secondPart1);
            }
            if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2)) {
                return new SandhiResponse(true, firstPart, secondPart2);
            }
            return new SandhiResponse(false);
        } else {
            return new SandhiResponse(false);
        }
    }
}
