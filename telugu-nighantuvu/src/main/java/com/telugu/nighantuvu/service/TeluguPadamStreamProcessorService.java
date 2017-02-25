package com.telugu.nighantuvu.service;

import com.telugu.nighantuvu.Nighantuvu;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by vinaykk on 25/02/17.
 */
public class TeluguPadamStreamProcessorService {
    private NighantuvuService nighantuvuService;

    public TeluguPadamStreamProcessorService() {
        this.nighantuvuService = new NighantuvuService();
    }

    public void processSet(String fileName) {
        File nighantuvuFile = new File(getClass().getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(nighantuvuFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.startsWith("-")) {
                    processLine(line);
                }
            }
            scanner.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processLine(String token) {
         StringBuilder str = new StringBuilder();
         int i = 0;
        while (i < token.length()) {
        	char val = token.charAt(i);
            if(isNonTeluguCharacter(token.charAt(i))) {
                i++;
            } else {
                while(i < token.length() && !isNonTeluguCharacter(token.charAt(i))) {
                    str.append(token.charAt(i));
                    i++;
                }
                nighantuvuService.processWord(str.toString());
                str.setLength(0);
                str.trimToSize();
            }
        }
    }
    
    public void outputDictinoryValues(String filePath) {
    	nighantuvuService.publishNighantuvuWords(filePath);
    }

    public boolean isNonTeluguCharacter(char ch) {
        return Character.UnicodeBlock.of(ch) != Character.UnicodeBlock.TELUGU;
    }

    public Nighantuvu getNighantuvu() {
        return nighantuvuService.getNighantuvu();
    }

}
