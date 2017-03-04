package com.telugu.nighantuvu.service;

import com.telugu.models.SandhiResponse;
import com.telugu.nighantuvu.Nighantuvu;

import com.telugu.sandhi.SandhiService;
import com.telugu.telscript.TeluguScript;
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
		service.processSet(eenaduSet);

		String eenaduSet2 = "/eenadu/eenaduSukheebhava.txt";
		service.processSet(eenaduSet2);

		String eenaduSet3 = "/eenadu/eenaduTemples.txt";
		service.processSet(eenaduSet3);
		service.outputDictinoryValues("/Users/vinaykk/telugu-words/nighantuvu-generated-4.txt");
		Nighantuvu nighantuvu = service.getNighantuvu();
		Assert.assertTrue(nighantuvu.getWords().size() > 100);

		//for (String str : nighantuvu.getWords()) {
		//	System.out.println(str);
		//}
	}

	//@Test
	public void testSandhi() {
		TeluguPadamStreamProcessorService service = new TeluguPadamStreamProcessorService();
		TeluguScript ts = new TeluguScript();
		System.out.println(ts.t("దేవాలయ", "telugu", "hk"));

		String testSet = "/test.txt";
		service.processSet(testSet);

		Nighantuvu nighantuvu = service.getNighantuvu();

		SandhiService sandhiService = new SandhiService(nighantuvu);
		SandhiResponse response = sandhiService.isSandhi("దేవాలయ", true);

		Assert.assertTrue(response.isSandhi());
		Assert.assertFalse(nighantuvu.contains(ts.t("దేవాలయ", "telugu", "hk")));

	}
}
