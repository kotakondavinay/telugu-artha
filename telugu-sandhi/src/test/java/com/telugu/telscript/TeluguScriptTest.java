package com.telugu.telscript;

/**
 * Created by vinaykk on 26/01/17.
 */
public class TeluguScriptTest {

    public void testTelugu() {
        TeluguScript tc = new TeluguScript();
        String translate1 = tc.t("పర్యటక జట్టులోకి జట్టులొకి కొత్తగా వచ్చిన ఎడమచేతి వాటం అతడి" , "telugu", "hk");
        System.out.println(translate1);

    }
}
