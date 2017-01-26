package com.telugu.sandhi.sanskrit;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.Sandhi;
import com.telugu.sandhi.models.SandhiResponse;

/**
 * Created by vinaykk on 26/01/17.
 */
public class SavarnaDheergaSandhi implements Sandhi {

    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu) {
        String token  = tokenString.replace("aa" , "A").replace("ee", "I").replace("uu", "U").replace("oo", "U");
        if(token.contains("A")) {
            String[] split = token.split("A");
            for(int i = 0 ; i < split.length - 1; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < i ; j++) {
                    sb.append(split[j]).append("A");
                }
                sb.append(split[i]);
                String splitFirstPart = sb.toString();
                sb = new StringBuilder();
                for( int j = i+1; j < split.length - 1; j++) {
                    sb.append(split[j]).append("A");
                }
                sb.append(split[split.length-1]);
                String splitSecondPart = sb.toString();

                String firstPart = splitFirstPart+"a";
                String secondPart1 = "a" + splitSecondPart;
                String secondPart2 = "A" + splitSecondPart;
                String secondPart2Alt1 = "aa" + splitSecondPart;
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart1)) {
                    return new SandhiResponse(true, firstPart, secondPart1);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2)) {
                    return new SandhiResponse(true, firstPart, secondPart2);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2Alt1)) {
                    return new SandhiResponse(true, firstPart, secondPart2Alt1);
                }
            }
        }
        if(token.contains("I")) {
            String[] split = token.split("I");
            for(int i = 0 ; i < split.length - 1; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < i ; j++) {
                    sb.append(split[j]).append("I");
                }
                sb.append(split[i]);
                String splitFirstPart = sb.toString();
                sb = new StringBuilder();
                for( int j = i+1; j < split.length - 1; j++) {
                    sb.append(split[j]).append("I");
                }
                sb.append(split[split.length-1]);
                String splitSecondPart = sb.toString();

                String firstPart = splitFirstPart+"i";
                String secondPart1 = "i" + splitSecondPart;
                String secondPart2 = "I" + splitSecondPart;
                String secondPart2Alt1 = "ee" + splitSecondPart;
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart1)) {
                    return new SandhiResponse(true, firstPart, secondPart1);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2)) {
                    return new SandhiResponse(true, firstPart, secondPart2);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2Alt1)) {
                    return new SandhiResponse(true, firstPart, secondPart2Alt1);
                }
            }
        }
        if(token.contains("U")) {
            String[] split = token.split("U");
            for(int i = 0 ; i < split.length - 1; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < i ; j++) {
                    sb.append(split[j]).append("U");
                }
                sb.append(split[i]);
                String splitFirstPart = sb.toString();
                sb = new StringBuilder();
                for( int j = i+1; j < split.length-1; j++) {
                    sb.append(split[j]).append("U");
                }
                sb.append(split[split.length-1]);
                String splitSecondPart = sb.toString();

                String firstPart = split[0]+"u";
                String secondPart1 = "u" + split[1];
                String secondPart2 = "U" + split[1];
                String secondPart2Alt1 = "uu" + split[1];
                String secondPart2Alt2 = "oo" + split[1];
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart1)) {
                    return new SandhiResponse(true, firstPart, secondPart1);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2)) {
                    return new SandhiResponse(true, firstPart, secondPart2);
                }
                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2Alt1)) {
                    return new SandhiResponse(true, firstPart, secondPart2Alt1);
                }

                if(nighantuvu.contains(firstPart) && nighantuvu.contains(secondPart2Alt2)) {
                    return new SandhiResponse(true, firstPart, secondPart2Alt2);
                }
            }
        }
        return new SandhiResponse(false);
    }
}
