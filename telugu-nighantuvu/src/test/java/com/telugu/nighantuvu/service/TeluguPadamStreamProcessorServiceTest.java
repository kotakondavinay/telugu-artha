package com.telugu.nighantuvu.service;

import com.telugu.nighantuvu.Nighantuvu;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vinaykk on 25/02/17.
 */
public class TeluguPadamStreamProcessorServiceTest {

	@Test
	public void testEenadu() {
		TeluguPadamStreamProcessorService service = new TeluguPadamStreamProcessorService();
		String eenaduSet = "/eenadu/eenadu1.txt";
		service.processEenaduSet(eenaduSet);

		String eenaduSet2 = "/eenadu/eenaduSukheebhava.txt";
		service.processEenaduSet(eenaduSet2);

		String eenaduSet3 = "/eenadu/eenaduTemples.txt";
		service.processEenaduSet(eenaduSet3);
		service.outputDictinoryValues("/Users/vinaykk/telugu-words/nighantuvu-generated-1.txt");
		Nighantuvu nighantuvu = service.getNighantuvu();
		Assert.assertTrue(nighantuvu.getWords().size() > 100);

		//for (String str : nighantuvu.getWords()) {
		//	System.out.println(str);
		//}
	}
}
