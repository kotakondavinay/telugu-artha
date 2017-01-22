package com.telugu.sandhi.models;

import com.sun.tools.javac.util.StringUtils;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiResponse {
    private boolean isSandhi;
    private String firstPart;
    private String secondPart;

    public SandhiResponse(boolean isSandhi) {
        this.isSandhi = isSandhi;
        this.firstPart = "";
        this.secondPart = "";
    }

    public SandhiResponse(boolean isSandhi, String firstPart, String secondPart) {
        this.isSandhi = isSandhi;
        this.firstPart = firstPart;
        this.secondPart = secondPart;
    }

    public boolean isSandhi() {
        return isSandhi;
    }

    public void setSandhi(boolean sandhi) {
        isSandhi = sandhi;
    }

    public String getFirstPart() {
        return firstPart;
    }

    public void setFirstPart(String firstPart) {
        this.firstPart = firstPart;
    }

    public String getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(String secondPart) {
        this.secondPart = secondPart;
    }
}
