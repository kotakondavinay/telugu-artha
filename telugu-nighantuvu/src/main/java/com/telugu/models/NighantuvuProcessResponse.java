package com.telugu.models;

/**
 * Created by vinaykk on 25/02/17.
 */
public class NighantuvuProcessResponse {
    private boolean isAdded;
    private  boolean isDeleted;
    private boolean isExists;
    private String word;

    public NighantuvuProcessResponse(boolean isAdded, boolean isDeleted, boolean isExists, String word) {
        this.isAdded = isAdded;
        this.isDeleted = isDeleted;
        this.isExists = isExists;
        this.word = word;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public boolean isExists() {
        return isExists;
    }

    public String getWord() {
        return word;
    }
}