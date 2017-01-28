package com.telugu.telscript;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vinaykk on 26/01/17.
 */
public class TeluguScriptTest {

    @Test
    public void testTelugu() {
        TeluguScript tc = new TeluguScript();
        String translate1 = tc.t("జట్టులోకి" , "telugu", "hk");
        Assert.assertEquals("jaTTulOki", translate1);
        String translate2 = tc.t("జట్టులొకి" , "telugu", "hk");
        Assert.assertEquals("jaTTuloki", translate2);
        String translate3 = tc.t("ఎడమచేతి" , "telugu", "hk");
        Assert.assertEquals("eDamacEti", translate3);
        String translate4 = tc.t("పర్యటక" , "telugu", "hk");
        Assert.assertEquals("paryaTaka", translate4);

        String translate5 = tc.t("జగత్" , "telugu", "hk");
        Assert.assertEquals("jagat", translate5);
        String translate6 = tc.t("నివాసం" , "telugu", "hk");
        Assert.assertEquals("nivAsaM", translate6);
        String translate7 = tc.t("జగన్నివాసం" , "telugu", "hk");
        Assert.assertEquals("jagannivAsaM", translate7);

        String translate8 = tc.t("ధనుః", "telugu", "hk");
        Assert.assertEquals("dhanuH", translate8);

    }
}
