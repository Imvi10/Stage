package com.keosys.dataGen.bussines;

/**
 * ***************************************************************************
 * Class Name                                     Visit
 *
 *
 * @author                                        Ivan Emmanuel VILLEGAS LIRA * 
 * Date                                           20/06/2016
 *
 * @description                                   Cette classe sert à exécuter
 *                                                une instance de benerator pour
 *                                                générer des données et les 
 *                                                insérer vers la base de
 *                                                données
 * @version                                       1.0.0 * *
 * ***************************************************************************
 */
import com.keosys.dataGen.db.DBConnection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Visit {

    com.keosys.dataGen.db.DBConnection connection;
    Utilities util;

    /**
     *
     * @return Tableau des visites
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Visit[] getVisits() throws SQLException {
        connection = new DBConnection();
        return connection.getVisits();

    }

    /**
     *
     * @param codePatient pour filtrer es visites selon le code du patient 
     * @return lesVisites tableau des visites filtres pour le code patient de
     * cette manière on ne montre que les visites possibles pour lui par rapport
     * à son protocol
     * @throws Exception
     */
    public com.keosys.dataGen.bean.Visit[] getVisitsByCodePatient(String codePatient) throws Exception {
        connection = new DBConnection();
        return connection.getVisitsByPatient(codePatient);
    }
    
    /**
     * 
     * @return La dernière visite dans la base de données
     * @throws SQLException 
     */
    public com.keosys.dataGen.bean.Visit getLastVisit() throws SQLException {
        connection = new DBConnection();
        return connection.getLastVisit();
    }

    /**
     *  Méthode qui permet modifier le fichier
     * Imagys/properties/visit.properties pour l'exécution de benerator les
     * paramètres viennent du jsp @see files/fileVisit.jsp
     * @param codeTypeVisit
     * @param idTypeVisit
     * @param idPatient
     * @return 
     */
    public boolean modifyVisitFile(String codeTypeVisit, String idTypeVisit, String idPatient) {
        util = new Utilities();
        String pathParent;
        try {
            pathParent = util.getImagysFolder();
            String path = pathParent + "properties/visit.properties";
            FileInputStream in = new FileInputStream(path);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(path);
            props.setProperty("code", codeTypeVisit);
            props.setProperty("FK_TYPE_VISIT_TYPE_ID", idTypeVisit);
            props.setProperty("FK_PATIENT_VISITS_ID", idPatient);
            props.store(out, null);
            out.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec le fichier Imagys/properties/visit.properties non trouvé ");
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    
    /**
     *
     * Méthode qui fait l'exécution de benerator avec le fichier
     * Imagys/patient.xml qui prenne le fichier
     * Imagys/properties/patient.properties pour faire l'insertion vers la base
     * de données via benerator
     *
     * @return Boolean selon la exécution 
     */
    public boolean generate() {
        util = new Utilities();
        String pathParent;
        try {
            pathParent = util.getImagysFolder();
            String beneratorPath = util.getBeneratorPath();
            String xmlPath = pathParent + "visit.xml";
            Process p = Runtime.getRuntime().exec(beneratorPath + " " + xmlPath);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                Logger.getLogger(Visit.class.getName()).log(Level.INFO, null, line);
            }
            return true;
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec l'exécution de benerator fichier non trouvé ");
            return false;
        }
    }
}
