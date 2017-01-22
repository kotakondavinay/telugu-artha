package com.telugu.sandhi;

import com.telugu.sandhi.models.SandhiResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by vinaykk on 22/01/17.
 */
public class SandhiTest {

    @Test
    public void testSandhi() {
        Sandhi s = new Sandhi();
        SandhiResponse isSandhi1 = s.isSandhi("himaadri");
        assertEquals(isSandhi1.isSandhi(), true);
        assertEquals(isSandhi1.getFirstPart(), "hima");
        assertEquals(isSandhi1.getSecondPart(), "adri");

        SandhiResponse isSandhi2 = s.isSandhi("himadri");
        assertEquals(isSandhi2.isSandhi(), false);
        assertEquals(isSandhi2.getFirstPart(), "");
        assertEquals(isSandhi2.getSecondPart(), "");

        SandhiResponse isSandhi3 = s.isSandhi("shivaalayam");
        assertEquals(isSandhi3.isSandhi(), true);
        assertEquals(isSandhi3.getFirstPart(), "shiva");
        assertEquals(isSandhi3.getSecondPart(), "aalayam");

    }
}
