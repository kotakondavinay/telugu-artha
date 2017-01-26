package com.telugu.sandhi;

import com.telugu.sandhi.models.SandhiResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiTest {

    @Test
    public void testSandhi() {
        SandhiService s = new SandhiService();
        SandhiResponse isSandhi1 = s.isSandhi("himaadri");
        assertEquals(true, isSandhi1.isSandhi());
        assertEquals("hima", isSandhi1.getFirstPart());
        assertEquals("adri", isSandhi1.getSecondPart());

        SandhiResponse isSandhi2 = s.isSandhi("himadri");
        assertEquals(false, isSandhi2.isSandhi());
        assertEquals("", isSandhi2.getFirstPart());
        assertEquals("", isSandhi2.getSecondPart());

        SandhiResponse isSandhi3 = s.isSandhi("shivaalayam");
        assertEquals(true, isSandhi3.isSandhi());
        assertEquals("shiva", isSandhi3.getFirstPart());
        assertEquals("aalayam",isSandhi3.getSecondPart());

        SandhiResponse isSandhi4 = s.isSandhi("raamaalayam");
        assertEquals(true, isSandhi4.isSandhi());
        assertEquals("rAma", isSandhi4.getFirstPart());
        assertEquals("aalayam", isSandhi4.getSecondPart());


    }
}
