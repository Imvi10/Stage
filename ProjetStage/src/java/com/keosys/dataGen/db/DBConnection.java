package com.keosys.dataGen.db;
/**
 * ***************************************************************************
 * Class Name                                     DBConnection
 *
 *
 * @author                                        Ivan Emmanuel VILLEGAS LIRA * 
 * Date                                           20/06/2016
 *
 * @description                                   Cette classe sert à exécuter
 *                                                des requetes SQL et insérer 
 *                                                et obtenir données depuis la
 *                                                base de données.
 * @version                                       1.0.0 * *
 * ***************************************************************************
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.keosys.dataGen.bean.InfoType;
import com.keosys.dataGen.bean.Information;
import com.keosys.dataGen.bean.JoinUserPatient;
import com.keosys.dataGen.bean.JoinVisitUser;
import com.keosys.dataGen.bean.Patient;
import com.keosys.dataGen.bean.Protocol;
import com.keosys.dataGen.bean.Serie;
import com.keosys.dataGen.bean.TypeVisit;
import com.keosys.dataGen.bean.User;
import com.keosys.dataGen.bean.Visit;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection connection = null;
    private static Connection connection2 = null;
    ResultSet rs;
    Statement stm;
    Protocol[] lesProtocols;
    Patient[] lesPatients;
    Visit[] lesVisites;
    TypeVisit[] lesTypesVisite;
    Serie[] lesSeries;
    User[] lesUtilisateurs;
    InfoType[] lesTypesInfo;
    Information[] lesInformations;

    public DBConnection() {

    }

    /**
     * Méthode que sert à verifier s'il existe connection entre le système et la
     * base de données
     *
     * @param ipServer
     * @param port
     * @param user
     * @param pass
     * @return Bolean selon le succès de la exécution
     * @throws SQLException
     */
    public boolean connectDb(String ipServer, int port, String user, String pass) throws SQLException {
        String url = "jdbc:mysql://" + ipServer + ":" + port;
        String username = user;
        String password = pass;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
            connection.close();
            return true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "La connection a échoué, il faut verifier le Driver MYSQL ");
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    /**
     * Méthode qui ferme la connection 2 qui est utilise d'une manière
     * persintente il s'exécute au LogOut.
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        connection2.close();
    }

    /**
     * Méthode qui fait une connexion qui sera utilisé pendant toute l'exécution
     * de la sesion en cours
     *
     * @param ipServer
     * @param port
     * @param user
     * @param pass
     * @param dbName
     * @return
     * @throws SQLException
     */
    public static Connection connectPersistence(String ipServer, int port, String user, String pass, String dbName) throws SQLException {
        String url = "jdbc:mysql://" + ipServer + ":" + port + "/" + dbName;

        try {
            if (connection2 == null) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection2 = DriverManager.getConnection(url, user, pass);
                return connection2;
            } else {
                connection2 = null;
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "La connection a échoué, il faut verifier le Driver MYSQL ");
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, e);
        }
        return connection2;
    }

    /**
     * Méthode qui obtinne les noms des bases de données qui sont disponibles
     * dans le serveur connecte
     *
     * @param ipServer
     * @param port
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    public String[] getDatabases(String ipServer, int port, String user, String pass) throws SQLException {
        String url = "jdbc:mysql://" + ipServer + ":" + port + "";
        String username = user;
        String password = pass;
        String[] tableNames = null;
        Connection cnx;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnx = DriverManager.getConnection(url, username, password);
            stm = (Statement) cnx.createStatement();
            rs = stm.executeQuery("SHOW DATABASES");
            tableNames = new String[getResultSetRowCount(rs)];
            int i = 0;
            while (rs.next()) {
                tableNames[i] = rs.getString("Database");
                i++;
            }
            closeResulsetStatement();
            connection.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "La connection a échoué, il faut verifier le Driver MYSQL ");
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE.SEVERE, null, e);
        }

        return tableNames;
    }

    /**
     * *
     * Fermature du Resulset
     *
     * @throws SQLException
     */
    public void closeResulset() throws SQLException {
        this.rs.close();
    }

    /**
     * Fermature des Statement et connection fin de reutiliser le code
     *
     * @throws SQLException
     */
    public void closeResulsetStatement() throws SQLException {
        try {
            if (rs != null) {
                closeResulset();
            }
            this.stm.close();
        } catch (Exception e) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, "Il y a eu un problème avec la fermature des Reslsets et Statements");
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE.SEVERE, null, e);
        }
    }

    /**
     *
     * @param resultSet à executer pour obtenir la taille du tableau qu'on va
     * construire depuis la basse des données
     * @return Le nombre des régistres de la basse des donnes de tel table
     */
    public static int getResultSetRowCount(ResultSet resultSet) {
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (Exception ex) {
            return 0;
        }
        return size;
    }

    /**
     *
     * @return lesProtocols Sélection depuis la basse des données pour y monter
     * dans l'interface
     * @throws SQLException
     */
    public Protocol[] getProtocols() throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id,code FROM protocol");
        lesProtocols = new Protocol[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Protocol temp = new Protocol();
            temp.setId(rs.getInt("id"));
            temp.setCode(rs.getString("code"));
            lesProtocols[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesProtocols;
    }

    /**
     * @param idUser
     * @return lesPatients Sélection depuis la basse des données pour y monter
     * dans l'interface
     * @throws SQLException
     */
    public Patient[] getPatients(int idUser) throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("select * from patient where id = any(select PATIENT_ID from join_users_patients where USER_ID = any( select id from user where id = " + idUser + ")) order by id desc");
        lesPatients = new Patient[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Patient temp = new Patient();
            temp.setId(rs.getInt("id"));
            temp.setCode(rs.getString("code"));
            temp.setFK_PROTOCOL_PATIENTS_ID(rs.getInt("FK_PROTOCOL_PATIENTS_ID"));
            lesPatients[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesPatients;
    }

    /**
     *
     * @return lesTypesVisite Sélection depuis la basse des données pour y
     * monter dans l'interface
     * @throws SQLException
     */
    public TypeVisit[] getTypesVisit(String codePatient) throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id, name , FK_PROTOCOL_VISIT_TYPES_ID  FROM visit_type where FK_PROTOCOL_VISIT_TYPES_ID = any(select FK_PROTOCOL_PATIENTS_ID from patient where code like '" + codePatient + "') ;");
        lesTypesVisite = new TypeVisit[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            TypeVisit temp = new TypeVisit();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setFkProtocolVisitTypes(rs.getInt("FK_PROTOCOL_VISIT_TYPES_ID"));
            lesTypesVisite[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesTypesVisite;
    }

    /**
     *
     * @return lesVisites Sélection depuis la basse des données pour y monter
     * dans l'interface
     * @throws SQLException
     */
    public Visit[] getVisits() throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id, code, FK_TYPE_VISIT_TYPE_ID, FK_PATIENT_VISITS_ID  FROM visit");
        lesVisites = new Visit[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Visit temp = new Visit();
            temp.setId(rs.getInt("id"));
            temp.setCode(rs.getString("code"));
            temp.setFK_TYPE_VISIT_TYPE_ID(rs.getInt("FK_TYPE_VISIT_TYPE_ID"));
            temp.setFK_PATIENT_VISITS_ID(rs.getInt("FK_PATIENT_VISITS_ID"));
            lesVisites[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesVisites;
    }

    /**
     *
     * @return lesVisites Sélection des visites qui sont possibles de réaliser
     * par rapport au protocol d'un patient
     * @throws SQLException
     */
    public Visit[] getVisitsByPatient(String codePatient) throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id, code, FK_TYPE_VISIT_TYPE_ID, FK_PATIENT_VISITS_ID  FROM visit where FK_PATIENT_VISITS_ID = "
                + "  any(select id from patient where code like  '" + codePatient + "')");
        lesVisites = new Visit[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Visit temp = new Visit();
            temp.setId(rs.getInt("id"));
            temp.setCode(rs.getString("code"));
            temp.setFK_TYPE_VISIT_TYPE_ID(rs.getInt("FK_TYPE_VISIT_TYPE_ID"));
            temp.setFK_PATIENT_VISITS_ID(rs.getInt("FK_PATIENT_VISITS_ID"));
            lesVisites[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesVisites;
    }

    /**
     *
     * @return Tableau des Series pour monter dans l'interface
     * @throws SQLException
     */
    public Serie[] getSeries() throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id, STATUS, AUTHOR_ID, FK_VISIT_SERIES_ID  FROM serie ");
        lesSeries = new Serie[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Serie temp = new Serie();
            temp.setId(rs.getInt("id"));
            temp.setStatus(rs.getInt("STATUS"));
            temp.setAuthorId(rs.getInt("AUTHOR_ID"));
            temp.setFkVisitSeriesId(rs.getInt("FK_VISIT_SERIES_ID"));
            lesSeries[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesSeries;
    }

    /**
     *
     * @return Tableau des utilisateurs aui ont le role de investigateur pour
     * monter dans l'interface
     * @throws SQLException
     */
    public User[] getUsers(int idProtocol) throws SQLException {
        stm = (Statement) connection2.createStatement();
        String query = "select  id, surname, first_name , login from user where id = any(select user_id from join_users_profils where PROFIL_ID = any( select id from profil where id = any (select PROFIL_ID from join_protocols_profils where PROTOCOL_ID =" + idProtocol + "))) order by login asc;  ";
        rs = stm.executeQuery(query);
        lesUtilisateurs = new User[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            User temp = new User();
            temp.setId(rs.getInt("id"));
            temp.setSurName(rs.getString("surname"));
            temp.setFirstName(rs.getString("first_name"));
            temp.setLogin(rs.getString("login"));
            lesUtilisateurs[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesUtilisateurs;
    }

    /**
     *
     * @return Tableau des TypesInformation pour monter dans l'interface
     * @throws SQLException
     */
    public InfoType[] getTypesInfo() throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id,ENTITY_TYPE, LABEL, NEEDED  FROM info_type ");
        lesTypesInfo = new InfoType[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            InfoType temp = new InfoType();
            temp.setId(rs.getInt("id"));
            temp.setEntityType(rs.getString("ENTITY_TYPE"));
            temp.setLabel(rs.getString("label"));
            temp.setNeeded(rs.getInt("NEEDED"));
            lesTypesInfo[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesTypesInfo;
    }

    /**
     *
     * @param codePatient
     * @return Patient filtre par code
     * @throws SQLException
     */
    public Patient getPatientByCodePatient(String codePatient) throws SQLException {
        stm = (Statement) connection2.createStatement();
        Patient temp = new Patient();
        String query = "select id, code, FK_PROTOCOL_PATIENTS_ID from  patient where code like '" + codePatient + "';";
        rs = stm.executeQuery(query);
        while (rs.next()) {
            temp.setId(rs.getInt("id"));
            temp.setCode(rs.getString("code"));
            temp.setFK_PROTOCOL_PATIENTS_ID(rs.getInt("FK_PROTOCOL_PATIENTS_ID"));
        }
        closeResulsetStatement();
        return temp;
    }

    /**
     * Méthode générique pour faire des insertions
     *
     * @param insertStatement
     * @throws SQLException
     */
    public void insert(String insertStatement) throws SQLException {
        stm = connection2.createStatement();
        stm.executeUpdate(insertStatement);
        closeResulsetStatement();
    }

    /**
     * Formation des Strings (Queries) pour inserer les donnes depuis le methode
     * insert
     *
     * @param info Objet de type information qui contienne les donnes a
     * @throws SQLException
     */
    public void insertInfoTypePatient(Information info) throws SQLException {
        String insertInfoTypePatient = "INSERT INTO information (`VALUE`, FK_TYPE_INFO_TYPE_ID, FK_PATIENT_MORE_INFOS_ID) VALUES('" + info.getVALUE() + "', " + info.getFK_TYPE_INFO_TYPE_ID() + ", " + info.getFK_PATIENT_MORE_INFOS_ID() + ");";
        insert(insertInfoTypePatient);
    }

    /**
     * Formation des Strings pour inserer dans le tableau Information par
     * rapport aux informations d'une serie insert
     *
     * @param info Objet de type information qui contienne les donnes a
     * @throws SQLException
     */
    public void insertInfoTypeSerie(Information info) throws SQLException {
        String insertInfoTypeSerie = "INSERT INTO information (VALUE, FK_TYPE_INFO_TYPE_ID,FK_SERIE_MORE_INFOS_ID) VALUES"
                + "('" + info.getVALUE() + "'," + info.getFK_TYPE_INFO_TYPE_ID() + "," + info.getFK_SERIE_MORE_INFOS_ID() + ");";
        insert(insertInfoTypeSerie);
    }

    /**
     * Formation des Strings pour inserer dans le tableau Information par
     * rapport aux informations d'une visite
     *
     * @param info
     * @throws SQLException
     */
    public void insertInfoTypeVisit(Information info) throws SQLException {
        String insertInfoTypeSerie = "INSERT INTO information (VALUE, FK_TYPE_INFO_TYPE_ID,FK_SERIE_MORE_INFOS_ID) VALUES"
                + "('" + info.getVALUE() + "'," + info.getFK_TYPE_INFO_TYPE_ID() + "," + info.getFK_VISIT_MORE_INFOS_ID() + ");";
        insert(insertInfoTypeSerie);
    }

    /**
     *
     * @return dernière Serie insére dans la base de données
     * @throws SQLException
     */
    public Serie getLastSerie() throws SQLException {
        Serie serie = new Serie();
        stm = (Statement) connection2.createStatement();
        String query = "Select id from serie  order by id desc limit 1;";
        rs = stm.executeQuery(query);
        rs.next();
        serie.setId(rs.getInt("id"));
        closeResulsetStatement();
        return serie;
    }

    /**
     *
     * @param typeInfo String pour le champ ENTITY_TYPE
     * @return Tableau des types d'information pour réaliser son générations
     * dans l'interface
     * @throws SQLException
     */
    public InfoType[] getTypesInfo(String typeInfo) throws SQLException {
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id,ENTITY_TYPE, LABEL, NEEDED  FROM info_type where ENTITY_TYPE like '" + typeInfo + "'");
        lesTypesInfo = new InfoType[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            InfoType temp = new InfoType();
            temp.setId(rs.getInt("id"));
            temp.setEntityType(rs.getString("ENTITY_TYPE"));
            temp.setLabel(rs.getString("label"));
            temp.setNeeded(rs.getInt("NEEDED"));
            lesTypesInfo[i] = temp;
            i++;
        }
        closeResulsetStatement();
        return lesTypesInfo;
    }

    /**
     *
     * @return dernière Patient insére dans la base de données
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Patient getLastPatient() throws SQLException {
        Patient p = new Patient();
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery("SELECT id, code FROM patient ORDER BY ID DESC LIMIT 1 ");
        rs.next();
        p.setId(rs.getInt("id"));
        p.setCode(rs.getString("code"));
        closeResulsetStatement();
        return p;
    }

    /**
     *
     * @return dernière Visite insére dans la base de données
     * @throws SQLException
     */
    public com.keosys.dataGen.bean.Visit getLastVisit() throws SQLException {
        Visit v = new Visit();
        stm = (Statement) this.connection2.createStatement();
        rs = stm.executeQuery("SELECT id, code FROM visit ORDER BY ID DESC LIMIT 1 ");
        rs.next();
        v.setId(rs.getInt("id"));
        v.setCode(rs.getString("code"));
        closeResulsetStatement();
        return v;
    }

    /**
     * Méthode qui sert à inserer la rélation entre un patient et un utilisateur
     *
     * @param joinUserPatient qui contienne l'id patient et l'id user
     * @throws SQLException
     */
    public void insertUserPatient(JoinUserPatient joinUserPatient) throws SQLException {
        String insertUserPatient = "INSERT INTO join_users_patients (USER_ID , PATIENT_ID)values (" + joinUserPatient.getUserId() + "," + joinUserPatient.getIdPatient() + ");";
        insert(insertUserPatient);
    }

    /**
     * Méthode qui sert à inserer la rélation entre une visite et un utilisateur
     *
     * @param joinVisitUser qui contienne l'id patient et l'id user
     * @throws SQLException
     */
    public void insertUserVisit(JoinVisitUser joinVisitUser) throws SQLException {
        String insertUserPatient = "INSERT INTO join_visits_users (VISIT_ID, USER_ID )VALUES (" + joinVisitUser.getVisitId() + "," + joinVisitUser.getUserId() + ");";
        insert(insertUserPatient);
    }

    /**
     * Méthode qui sert à obtenir un tableau des informations des utilsateurs et
     * les centreus où ils sont
     *
     * @param idAuthor
     * @return
     * @throws SQLException
     */
    public Information[] getCentresByAuthor(int idAuthor) throws SQLException {
        String query = "SELECT id, value, FK_USER_MORE_INFOS_ID FROM information WHERE FK_TYPE_INFO_TYPE_ID = 10 and FK_USER_MORE_INFOS_ID = " + idAuthor + ";";
        stm = (Statement) connection2.createStatement();
        rs = stm.executeQuery(query);
        lesInformations = new Information[getResultSetRowCount(rs)];
        int i = 0;
        while (rs.next()) {
            Information temp = new Information();
            temp.setId(rs.getInt("id"));
            temp.setVALUE(rs.getString("value"));
            temp.setFK_USER_MORE_INFOS_ID(Integer.valueOf(rs.getString("FK_USER_MORE_INFOS_ID")));
            lesInformations[i] = temp;

        }
        closeResulsetStatement();
        return lesInformations;
    }

}
