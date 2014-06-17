/**
 * 
 */
package com.sxwz.otw.gendict.third.wordnet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.sxwz.otw.gendict.IGenDictFromThirdParty;

/**
 * @author Stephen.Zhang@Covisint.com
 * 
 */
public class GenDictFromWordNet implements IGenDictFromThirdParty {

    private static final String CLASS_NAME = GenDictFromWordNet.class.getCanonicalName();
    private static final Logger LOGGER = Logger.getLogger(GenDictFromWordNet.class);
    private String data_adj = "D:\\prjotw\\ontheway\\dictionaryProj\\material\\03reference\\031wordnet\\v3\\data.adj";
    private String data_adv = "D:\\prjotw\\ontheway\\dictionaryProj\\material\\03reference\\031wordnet\\v3\\data.adv";
    private String data_noun = "D:\\prjotw\\ontheway\\dictionaryProj\\material\\03reference\\031wordnet\\v3\\data.noun";
    private String data_verb = "D:\\prjotw\\ontheway\\dictionaryProj\\material\\03reference\\031wordnet\\v3\\data.verb";
    private final int start_line = 20;

    private static GenDictFromWordNet instance = new GenDictFromWordNet();

    /**
     * 
     */
    private GenDictFromWordNet() {
    }

    public static GenDictFromWordNet getInstance() {
        return instance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sxwz.otw.gendict.IGenDictFromThirdParty#genDictionaries()
     */
    public void genDictionaries() {
        String methodName = CLASS_NAME + ":genDictionaries:";

        BufferedReader br = null;
        String line = "";
        // READ noun
        try {
            int i = 0;
            br = new BufferedReader(new FileReader(data_noun));
            while ((line = br.readLine()) != null) {
                i++;
                if (i >= start_line) {
                    LOGGER.info(methodName + "i:" + i + ":line:" + line);
                    
                }

            }
        } catch (FileNotFoundException e) {
            LOGGER.info(methodName, e);
        } catch (IOException e) {
            LOGGER.info(methodName, e);
        }
    }

    public static void main(String[] args) {
        instance.genDictionaries();
    }

}
