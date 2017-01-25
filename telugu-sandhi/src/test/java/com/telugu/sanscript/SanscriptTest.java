package com.telugu.sanscript;


import com.telugu.telscript.TeluguScript;
import org.junit.Test;

/**
 * Created by vinaykk on 26/01/17.
 */
public class SanscriptTest {

    @Test
    public void test() {
        Sanscript sc = new Sanscript();
        String translate = sc.t("పర్యటక జట్టులోకి జట్టులొకి కొత్తగా వచ్చిన ఎడమచేతి వాటం అతడి" , "telugu", "hk");
        System.out.println(translate);

        TeluguScript tc = new TeluguScript();
        String translate1 = tc.t("పర్యటక జట్టులోకి జట్టులొకి కొత్తగా వచ్చిన ఎడమచేతి వాటం అతడి" , "telugu", "hk");
        System.out.println(translate1);

    }


}
