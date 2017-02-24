package com.telugu.sandhi.models;

import java.util.List;

/**
 * Created by vinaykk on 26/01/17.
 */
public class SandhiSeperator {
    private String seperator;
    private List<String> firstPartSuffixes;
    private List<String> secondPartPrefixes;

    public SandhiSeperator(String seperator, List<String> firstPartSuffixes, List<String> secondPartPrefixes) {
        this.seperator = seperator;
        this.firstPartSuffixes = firstPartSuffixes;
        this.secondPartPrefixes = secondPartPrefixes;
    }

    public String getSeperator() {
        return seperator;
    }

    public List<String> getFirstPartSuffixes() {
        return firstPartSuffixes;
    }

    public List<String> getSecondPartPrefixes() {
        return secondPartPrefixes;
    }
}
