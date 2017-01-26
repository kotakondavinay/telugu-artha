package com.telugu.sanscript;


import com.telugu.telscript.TeluguScript;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vinaykk on 26/01/17.
 */
public class SanscriptTest {

    @Test
    public void test() {
        Sanscript sc = new Sanscript();
        String translate = sc.t("జట్టులోకి" , "telugu", "hk");
        Assert.assertEquals("jaTTuloki", translate);
        Sanscript tc = new Sanscript();
        String translate1 = tc.t("జట్టులొకి" , "telugu", "hk");
        Assert.assertEquals("jaTTulki", translate1);
        //String translate2 = tc.t("jaTTulki" , "hk", "telugu");
        //Assert.assertEquals("జట్టులొకి", translate1);
    }
}
