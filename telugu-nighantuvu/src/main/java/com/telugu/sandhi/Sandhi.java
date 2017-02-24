package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.models.SandhiResponse;

/**
 * Created by vinaykk on 26/01/17.
 */
public interface Sandhi {
    public SandhiResponse isSandhi(String tokenString, Nighantuvu nighantuvu, boolean isTeluguScript);
}
