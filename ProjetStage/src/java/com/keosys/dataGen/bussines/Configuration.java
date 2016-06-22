package com.keosys.dataGen.bussines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ***************************************************************************
 * Class Name                           Configuration                        *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à configurer le    
 *                                      fichier @see config/paths.properties
 *                                      pour localiser les resources du 
 *                                      systèmme (Benerator executable 
 *                                      et imagys resources)
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */
public class Configuration {

    /**
     * Vérifie en base au beneratorPath si le fichier existe ou pas dans le
     * répertoire
     *
     * @param beneratorPath Reçu depuis le fichier @see files/fileConnexion.jsp
     * est le chémin vers benerator
     * @return Boolean après la vérification de la existance du fichier
     * benerator.bat
     */
    public boolean existBeneratorBat(String beneratorPath) {
        return verifyFile(beneratorPath) == true;
    }

    /**
     * Vérifie en base au imagysRep la existance des fichiers patient.xml,
     * visit.xml et serie.xml
     *
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     * @return Boolean après la vérification de la existance des fichiers
     * patient.xml, visit.xml et serie.xml
     */
    public boolean existDescriptorsXML(String imagysRep) {
        if (verifyFile(imagysRep + "patient.xml")) {
            if (verifyFile(imagysRep + "visit.xml")) {
                return verifyFile(imagysRep + "serie.xml");
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Vérifie en base au imagysRep la existance des fichiers
     * patient.properties, visit.properties et serie.properties dans le
     * repertoire imagys/properties
     *
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     * @return Boolean après la vérification de la existance des fichiers
     * imagys/propertie/patient.properties, imagys/propertie/visit.properties et
     * imagys/propertie/serie.properties
     */
    public boolean existtDescriptorProperties(String imagysRep) {
        if (verifyFile(imagysRep + "properties/patient.properties")) {
            if (verifyFile(imagysRep + "properties/visit.properties")) {
                if (verifyFile(imagysRep + "properties/serie.properties")) {
                    return verifyFile(imagysRep + "util/database.properties");
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Vérifie en base au imagysRep la existance du fichier descriptionSerie.csv
     * qui contienne une liste des description des series dans le repertoire
     * imagys/resources
     *
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     *
     * @return Boolean après la vérification de l'existance du fichier
     * imagys/resources/descriptionSerie.csv
     */
    public boolean existResources(String imagysRep) {
        return verifyFile(imagysRep + "resources/descriptionSerie.csv");
    }

    /**
     * Méthode générique pour verifier l'existance d'un fichier depuis d'un
     * paramètre qui contienne un chémin du système
     *
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     * @return Boolean après la vérification de l'existance du fichier
     */
    public boolean verifyFile(String imagysRep) {
        try {
            File f = new File(imagysRep);
            return f.exists() && !f.isDirectory();
        } catch (Exception ex) {
            Logger.getLogger(Configuration.class.getName(), "'" + imagysRep 
                    + "'" + "' not found ");
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE,
                    null, ex);
            return false;
        }
    }

    /**
     * Vérifie en base au imagysRep la existance du repertoire imagys/
     *
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     *
     * @return Boolean après la vérification de l'existance du fichier imagys/
     *
     */
    public boolean existImagysFolder(String imagysRep) {
        try {
            File folderImagys = new File(imagysRep);
            return folderImagys.isDirectory() && folderImagys.exists();
        } catch (Exception ex) {
            Logger.getLogger(Configuration.class.getName(), 
                    " 'Imagys' folder not found ");
            Logger.getLogger(Configuration.class.getName())
                    .log(Level.SEVERE, null, ex);
            
            return false;
        }
    }

    /**
     * L'execution de toutes les méthodes de la classe sont réalisses pour
     * pouvoir modifier ce fichier qui fait toute la communication entre le
     * système et le resources
     *
     * @param beneratorBat Reçu depuis le fichier @see files/fileConnexion.jsp
     * est le chémin vers le fichier benerator.bat
     * @param imagysRep Reçu depuis le fichier @see files/fileConnexion.jsp est
     * le chémin vers le répertoie avec les fichiers (resources)
     * @return Boolean pour savoir si le fichier a été bien modifié ou non et sa
     * cause
     * @throws FileNotFoundException Lancé en cas de ne trouver pas le fichier
     * /config/paths.properties dans le .WAR
     * @throws IOException
     * @throws URISyntaxException
     */
    public boolean modifyFile(String beneratorBat, String imagysRep) throws FileNotFoundException, IOException, URISyntaxException {
        try {
            URL url = getClass().getResource("/config/paths.properties");
            File configFile = new File(url.toURI());
            Properties props = new Properties();
            props.setProperty("pathBenerator", beneratorBat);
            props.setProperty("pathImagysRes", imagysRep);
            try (FileWriter writer = new FileWriter(configFile)) {
                props.store(writer, "Properties has changed");
            }
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, "Fichier src/java/config/paths.properties not found ");
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec la lecture ou ecriture du fichier src/java/config/paths.properties ");
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
