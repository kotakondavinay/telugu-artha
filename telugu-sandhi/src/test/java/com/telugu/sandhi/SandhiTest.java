package com.telugu.sandhi;

import com.telugu.sandhi.models.SandhiResponse;
import com.telugu.telscript.TeluguScript;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiTest {

    @Test
    public void testSavarnaSandhi() {
        SandhiService s = new SandhiService();
        SandhiResponse isSandhi1 = s.isSandhi("himaadri", false);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("hima", isSandhi1.getFirstPart());
        assertEquals("adri", isSandhi1.getSecondPart());


        SandhiResponse isSandhi1T = s.isSandhi("హిమాద్రి", true);
        assertEquals(true, isSandhi1T.isSandhi());
        assertEquals("hima", isSandhi1T.getFirstPart());
        assertEquals("adri", isSandhi1T.getSecondPart());

        SandhiResponse isSandhi2 = s.isSandhi("himadri", false);
        assertEquals(false, isSandhi2.isSandhi());
        assertEquals("", isSandhi2.getFirstPart());
        assertEquals("", isSandhi2.getSecondPart());

        SandhiResponse isSandhi3 = s.isSandhi("shivaalayaM", false);
        assertEquals(true, isSandhi3.isSandhi());
        assertEquals("shiva", isSandhi3.getFirstPart());
        assertEquals("aalayaM",isSandhi3.getSecondPart());

        SandhiResponse isSandhi4 = s.isSandhi("raamaalayaM", false);
        assertEquals(true, isSandhi4.isSandhi());
        assertEquals("rAma", isSandhi4.getFirstPart());
        assertEquals("aalayaM", isSandhi4.getSecondPart());


        /** Let's add some fun here to check in telugu language */
        // TODO. english to telugu translation is not working. fix this.
        String str = "రామాలయం";
        SandhiResponse resp1 = s.isSandhi(str , true);
        assertEquals(true, isSandhi4.isSandhi());
        assertEquals("rAma", isSandhi4.getFirstPart());
        assertEquals("aalayaM", isSandhi4.getSecondPart());
    }

    @Test
    public void testGuNaSandhi() {

        SandhiService s = new SandhiService();
        SandhiResponse isSandhi1 = s.isSandhi("mahOtsavaM", false);

        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("mahA", isSandhi1.getFirstPart());
        assertEquals("utsavaM", isSandhi1.getSecondPart());
    }

    @Test
    public void testAnunasikaSandhi() {
        /** Let's add some falvours. */

        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("jagannivAsaM", false);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("jagat", isSandhi1.getFirstPart());
        assertEquals("nivAsaM", isSandhi1.getSecondPart());

        SandhiResponse isSandhi1T = s.isSandhi("జగన్నివాసం", true);
        assertEquals(true, isSandhi1T.isSandhi());
        assertEquals(ts.t("జగత్", "telugu", "hk"), isSandhi1.getFirstPart());
        assertEquals(ts.t("నివాసం", "telugu", "hk"), isSandhi1.getSecondPart());
    }

    @Test
    public void testvRddiSandhi() {

        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("ఏకైశ్వర్యము", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals(ts.t("ఏక", "telugu", "hk"), isSandhi1.getFirstPart());
        assertEquals(ts.t("ఐశ్వర్యము","telugu","hk"), isSandhi1.getSecondPart());
    }

    @Test
    public void testYanaDesaSandhi() {

        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("ప్రత్యక్షము", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals(ts.t("ప్రతి", "telugu", "hk"), isSandhi1.getFirstPart());
        assertEquals(ts.t("అక్షము","telugu","hk"), isSandhi1.getSecondPart());

        SandhiResponse isSandhi2 = s.isSandhi("గౌర్యారాధనం", true);
        assertEquals(true, isSandhi2.isSandhi());
        assertEquals(ts.t("గౌరి", "telugu", "hk"), isSandhi2.getFirstPart());
        assertEquals(ts.t("ఆరాధనం","telugu","hk"), isSandhi2.getSecondPart());
    }
}
