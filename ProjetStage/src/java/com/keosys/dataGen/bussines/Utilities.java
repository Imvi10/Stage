package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                                     Utilities
 *
 *
 * @author                                        Ivan Emmanuel VILLEGAS LIRA * 
 * Date                                           20/06/2016
 *
 * @description                                   Cette classe sert à vérifier
 *                                                l'existance de tous les 
 *                                                résources extenres qui sont
 *                                                nécesssaire pour l'exécution 
 *                                                du système
 * @version 1.0.0 * *
 * ***************************************************************************
 */ 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {

    InputStream inputStream;

    
    /**
     * Méthode qui demande la propiéte appelé pathBenerator qui est dans le fichier config/paths.properties du .war 
     * @return le chémin vers benerator en String 
     * @throws IOException 
     */
    public String getBeneratorPath() throws IOException {
        String benerator = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config/paths.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            benerator = prop.getProperty("pathBenerator");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return benerator;
    }

    /**
     * Méthode qui demande la propiéte appelé pathImagysRes qui est dans le fichier config/paths.properties du .war 
     * @return le chémin vers le répertoire des réssources  en String 
     * @throws IOException 
     */
    String getImagysFolder() throws IOException {
        String imagys = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config/paths.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            imagys = prop.getProperty("pathImagysRes");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return imagys;
    }

}
