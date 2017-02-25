package com.telugu.nighantuvu.service;

import com.telugu.models.NighantuvuProcessResponse;
import com.telugu.nighantuvu.Nighantuvu;
import com.telugu.sandhi.SandhiService;
import com.telugu.telscript.TeluguScript;
import com.telugu.models.SandhiResponse;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vinaykk on 24/02/17.
 */
public class NighantuvuService {
	
    private Nighantuvu nighantuvu;
    private TeluguScript ts;
    private SandhiService sandhiService;
    Map<String, String> teluguToEnglish = new HashMap<String, String>();

    public NighantuvuService() {
        this.nighantuvu = new Nighantuvu();
        this.sandhiService = new SandhiService();
        this.ts = new TeluguScript();
        init();
    }

    public void init() {
        buildNighantuvuFiles("/nighantuvu.txt");
        //buildNighantuvuFiles("/nighantuvu-eenadu.txt");
    }

    private void buildNighantuvuFiles(String filePath) {
        File nighantuvuFile = new File(getClass().getResource(filePath).getFile());
        try (Scanner scanner = new Scanner(nighantuvuFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                nighantuvu.add(line.split("\t")[0]);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public NighantuvuProcessResponse processWord(String word) {

        SandhiResponse sandhiResponse = sandhiService.isSandhi(word, true);
        String tenglishWord = ts.t(word, "telugu", "hk");
        if (sandhiResponse.isSandhi()) {
            if (nighantuvu.contains(tenglishWord)) {
                nighantuvu.delete(tenglishWord);
                teluguToEnglish.remove(tenglishWord);
                return new NighantuvuProcessResponse(false, true, false, word);
            } else {
                return new NighantuvuProcessResponse(false, false, true, word);
            }
        } else {
            // TODOD. Check if they are any samaasam.
            if(!nighantuvu.contains(tenglishWord)) {
                nighantuvu.add(tenglishWord);
                teluguToEnglish.put(tenglishWord, word);
                return new NighantuvuProcessResponse(false, false, false, word);
            } else {
                return new NighantuvuProcessResponse(false, false, true, word);
            }
        }
    }

    public Nighantuvu getNighantuvu(){
        return nighantuvu;
    }
    
    @SuppressWarnings("rawtypes")
	public void publishNighantuvuWords(String filePath) {
    	try {
    	   // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter("/Users/vinaykk/telugu-words/nighantuvu-generated-1.txt"));
    		@SuppressWarnings("resource")
			FileWriter nighantuvuFile = new FileWriter(filePath);
    		Iterator it = teluguToEnglish.entrySet().iterator();
    		while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        nighantuvuFile.write(pair.getKey() + "\t" + pair.getValue() + "\n");
    	        it.remove();
    	    }
    		nighantuvuFile.close();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
