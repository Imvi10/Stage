package com.keosys.dataGen.bussines;

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

public class Patient {

    Utilities util = null;
    com.keosys.dataGen.db.DBConnection connection;

    /**
     *
     * @param idUser
     * @return lesPatients Tableau qui contienne les patients pour réaliser les
     * visites
     * @throws SQLException Connection à la base des données pas de risque
     * d'exception ici
     */
    public com.keosys.dataGen.bean.Patient[] getPatients(int idUser) throws SQLException {
        connection = new DBConnection();
        return connection.getPatients(idUser);
    }

    /**
     *
     * @param codePatient Sert à filtrer la liste des patients pour obtenir leur
     * information compete d'un patient
     *
     * @return Objet Patient qui correspond avec le codePatient qui recoive
     * dcomme paramètre
     * @throws SQLException Connection à la basse des données pas de risque
     * d'exception ici
     */
    public com.keosys.dataGen.bean.Patient getPatientByCodePatient(String codePatient) throws SQLException {
        connection = new DBConnection();
        return connection.getPatientByCodePatient(codePatient);
    }

    /**
     *
     * Méthode qui permet obtenir le dernièr patient insère dans la base de
     * données; patient dans le tableau joinUserPatient
     *
     * @return dernièr patient dans la base de données
     *
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Patient getLastPatient() throws SQLException {
        connection = new DBConnection();
        return connection.getLastPatient();
    }

    /**
     *
     * Méthode qui permet modifier le fichier
     * Imagys/properties/patient.properties pour l'exécution de benerator les
     * paramètres viennent du jsp @see files/filePatient.jsp
     *
     * @param idAuthor
     * @param codePatient
     * @param idProtocol
     * @return
     */
    public boolean modifyFile(String idAuthor, String codePatient, String idProtocol) {
        try {
            util = new Utilities();
            String pathParent = util.getImagysFolder();
            Properties props;
            String path = pathParent + "properties/patient.properties";
            FileInputStream in;
            in = new FileInputStream(path);
            props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream outFile = new FileOutputStream(path);
            props.setProperty("code", codePatient);
            props.setProperty("FK_PROTOCOL_PATIENTS_ID", idProtocol);
            props.store(outFile, null);
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec le fichier Imagys/properties/patient.properties non trouvé ");
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
        try {
            util = new Utilities();
            String pathParent = util.getImagysFolder();
            String xmlPath = pathParent + "patient.xml ";
            String beneratorPath = util.getBeneratorPath();
            Process p;
            p = Runtime.getRuntime().exec(beneratorPath + " " + xmlPath);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                Logger.getLogger(Patient.class.getName()).log(Level.INFO, null, line);
            }
            return true;
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Serie.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec l'exécution de benerator fichier non trouvé ");
            return false;
        }
    }

    public com.keosys.dataGen.bean.Patient patientExist(String codePatient) throws SQLException {
        connection = new DBConnection();
        System.out.println(connection.getPatientByCodePatient(codePatient));
        return connection.getPatientByCodePatient(codePatient);
    }

}
