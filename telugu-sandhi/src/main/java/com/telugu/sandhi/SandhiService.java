package com.telugu.sandhi;

import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.models.SandhiResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiService {
    private Nighantuvu nighantuvu;
    private List<Sandhi> sandhiList = new ArrayList<Sandhi>();

    public SandhiService() {
        this.nighantuvu = new Nighantuvu();
        sandhiList.add(new SavarnaDheergaSandhi());
    }

    public SandhiResponse isSandhi(String token) {
        for(Sandhi sandhi: sandhiList) {
                SandhiResponse response = sandhi.isSandhi(token, nighantuvu);
                if(response.isSandhi()){
                    return response;
                }
        }
        return new SandhiResponse(false);
    }
}
