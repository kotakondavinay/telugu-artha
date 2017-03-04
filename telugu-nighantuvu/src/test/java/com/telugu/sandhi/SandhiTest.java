package com.telugu.sandhi;

import com.telugu.models.SandhiResponse;
import com.telugu.sandhi.sanskrit.*;
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
        assertEquals(SavarnaDheergaSandhi.class.getName(), isSandhi1.getSandhiName());

        SandhiResponse isSandhi1T = s.isSandhi("హిమాద్రి", true);
        assertEquals(true, isSandhi1T.isSandhi());
        assertEquals("హిమ", isSandhi1T.getFirstPart());
        assertEquals("అద్రి", isSandhi1T.getSecondPart());
        assertEquals(SavarnaDheergaSandhi.class.getName(), isSandhi1T.getSandhiName());

        SandhiResponse isSandhi2 = s.isSandhi("himadri", false);
        assertEquals(false, isSandhi2.isSandhi());
        assertEquals("", isSandhi2.getFirstPart());
        assertEquals("", isSandhi2.getSecondPart());
        assertEquals("", isSandhi2.getSandhiName());

        SandhiResponse isSandhi3 = s.isSandhi("shivaalayaM", false);
        assertEquals(true, isSandhi3.isSandhi());
        assertEquals("shiva", isSandhi3.getFirstPart());
        assertEquals("aalayaM",isSandhi3.getSecondPart());
        assertEquals(SavarnaDheergaSandhi.class.getName(), isSandhi3.getSandhiName());

        SandhiResponse isSandhi4 = s.isSandhi("raamaalayaM", false);
        assertEquals(true, isSandhi4.isSandhi());
        assertEquals("rAma", isSandhi4.getFirstPart());
        assertEquals("aalayaM", isSandhi4.getSecondPart());
        assertEquals(SavarnaDheergaSandhi.class.getName(), isSandhi4.getSandhiName());


        /** Let's add some fun here to check in telugu language */
        // TODO. english to telugu translation is not working. fix this.
        String str = "రామాలయం";
        SandhiResponse resp1 = s.isSandhi(str , true);
        assertEquals(true, resp1.isSandhi());
        assertEquals("రామ", resp1.getFirstPart());
        assertEquals("ఆలయం", resp1.getSecondPart());
        assertEquals(SavarnaDheergaSandhi.class.getName(), resp1.getSandhiName());
    }

    @Test
    public void testGuNaSandhi() {

        SandhiService s = new SandhiService();
        SandhiResponse isSandhi1 = s.isSandhi("mahOtsavaM", false);

        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("mahA", isSandhi1.getFirstPart());
        assertEquals("utsavaM", isSandhi1.getSecondPart());
        assertEquals(GuNaSandhi.class.getName(), isSandhi1.getSandhiName());
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
        assertEquals(AnunasikaSandhi.class.getName(), isSandhi1.getSandhiName());

        SandhiResponse isSandhi1T = s.isSandhi("జగన్నివాసం", true);
        assertEquals(true, isSandhi1T.isSandhi());
        assertEquals("జగత్", isSandhi1T.getFirstPart());
        assertEquals("నివాసం", isSandhi1T.getSecondPart());
        assertEquals(AnunasikaSandhi.class.getName(), isSandhi1T.getSandhiName());
    }

    @Test
    public void testvRddiSandhi() {

        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("ఏకైశ్వర్యము", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("ఏక", isSandhi1.getFirstPart());
        assertEquals("ఐశ్వర్యము", isSandhi1.getSecondPart());
        assertEquals(VRddiSandhi.class.getName(), isSandhi1.getSandhiName());
    }

    @Test
    public void testYanaDesaSandhi() {

        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("ప్రత్యక్షము", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("ప్రతి", isSandhi1.getFirstPart());
        assertEquals("అక్షము", isSandhi1.getSecondPart());
        assertEquals(YanaDesaSandhi.class.getName(), isSandhi1.getSandhiName());

        SandhiResponse isSandhi2 = s.isSandhi("గౌర్యారాధనం", true);
        assertEquals(true, isSandhi2.isSandhi());
        assertEquals("గౌరి", isSandhi2.getFirstPart());
        assertEquals("ఆరాధనం", isSandhi2.getSecondPart());
        assertEquals(YanaDesaSandhi.class.getName(), isSandhi2.getSandhiName());
    }

    @Test
    public void testParasaVarnaSandhi() {
        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("విద్యుల్లత", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("విద్యుత్", isSandhi1.getFirstPart());
        assertEquals("లత", isSandhi1.getSecondPart());
        assertEquals(ParasavarnaSandhi.class.getName(), isSandhi1.getSandhiName());

    }

    @Test
    public void testSchuthvaSandhi() {
        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("సజ్జనులు", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("సత్", isSandhi1.getFirstPart());
        assertEquals("జనులు", isSandhi1.getSecondPart());
        assertEquals(SchutvaSandhi.class.getName(), isSandhi1.getSandhiName());
    }

    @Test
    public void testVisargaSandhi() {
        SandhiService s = new SandhiService();
        TeluguScript ts = new TeluguScript();

        SandhiResponse isSandhi1 = s.isSandhi("శిరోవేదన", true);
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("శిరః", isSandhi1.getFirstPart());
        assertEquals("వేదన", isSandhi1.getSecondPart());
        assertEquals(VisargaSandhi.class.getName(), isSandhi1.getSandhiName());

        SandhiResponse isSandhi2 = s.isSandhi("చతుష్షష్టి", true);
        assertEquals(true, isSandhi2.isSandhi());
        assertEquals("చతుః", isSandhi2.getFirstPart());
        assertEquals("షష్టి", isSandhi2.getSecondPart());
        assertEquals(VisargaSandhi.class.getName(), isSandhi2.getSandhiName());

    }
}
