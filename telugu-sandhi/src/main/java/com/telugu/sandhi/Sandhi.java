package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.models.SandhiResponse;

/**
 * Created by vinaykk on 26/01/17.
 */
public interface Sandhi {
    public SandhiResponse isSandhi(String token, Nighantuvu nighantuvu, boolean isTeluguScript);
}
