package com.keosys.dataGen.bussines;
/**
 * ***************************************************************************
 * Class Name                                     Serie
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
 * @version 1.0.0 * *
 * ***************************************************************************
 */
import java.sql.SQLException;

import com.keosys.dataGen.db.DBConnection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serie {

    Utilities util = null;
    com.keosys.dataGen.db.DBConnection connection;

    /**
     * Méthode qui obtienne toutes les series qui sont dans la base de données
     *
     * @return lesSeries Tableau des Series pour les associer avec les Vistes
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Serie[] getSeries() throws SQLException {
        connection = new DBConnection();
        return connection.getSeries();
    }

    /**
     * Méthode qui obtienne la dernièr serie stocke dans la base de données
     *
     * @return serie Objet Serie qui contienne le derni�ere id pour inserer dans
     * la table inforlation du type information Series
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Serie getLastSerie() throws SQLException {
        connection = new DBConnection();
        return connection.getLastSerie();
    }

    /**
     * Méthode qui permet modifier le fichier Imagys/properties/serie.properties
     * pour l'exécution de benerator les paramètres viennent du jsp @see
     * files/fileSerie.jsp
     *
     * @param idAuthor
     * @param visitId
     * @return
     */
    public boolean modifyFile(String idAuthor, String visitId) {
        try {
            util = new Utilities();
            String pathParent;
            pathParent = util.getImagysFolder();
            String path = pathParent + "properties/serie.properties";
            FileInputStream in = new FileInputStream(path);
            Properties props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(path);
            props.setProperty("FK_VISIT_SERIES_ID", visitId);
            props.setProperty("AUTHOR_ID", idAuthor);
            props.store(out, null);
            out.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec le fichier Imagys/properties/serie.properties non trouvé ");
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Méthode qui fait l'exécution de benerator avec le fichier
     * Imagys/serie.xml qui prenne le fichier Imagys/properties/serie.properties
     * pour faire l'insertion vers la base de données via benerator
     *
     * @return Boolean pour savoir si l'exécution a été bien faite
     */
    public boolean generate() {
        String pathParent;
        try {
            util = new Utilities();
            pathParent = util.getImagysFolder();
            String beneratorPath = util.getBeneratorPath();
            String xmlPath = pathParent + "serie.xml";
            Process p = Runtime.getRuntime().exec(beneratorPath + " " + xmlPath);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                Logger.getLogger(Serie.class.getName()).log(Level.INFO, null, line);
            }
            return true;
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec l'exécution de benerator fichier non trouvé ");
            return false;
        }

    }

}
