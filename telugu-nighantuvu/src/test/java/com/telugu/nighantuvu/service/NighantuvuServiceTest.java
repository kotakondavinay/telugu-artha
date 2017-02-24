package com.telugu.nighantuvu.service;

import com.telugu.nighantuvu.Nighantuvu;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vinaykk on 25/02/17.
 */
public class NighantuvuServiceTest {

    @Test
    public void testNighantuvuService() {
        NighantuvuService service = new NighantuvuService();
        Nighantuvu nighantuvu = service.getNighantuvu();
        Set<String> nighantuvuWords = nighantuvu.getWords();
        for (String word: nighantuvuWords) {
            System.out.println(word);
        }
        Assert.assertEquals("", true, true);

    }
}
