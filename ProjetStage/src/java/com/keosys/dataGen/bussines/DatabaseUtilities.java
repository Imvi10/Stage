package com.keosys.dataGen.bussines;

import com.keosys.dataGen.db.DBConnection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ***************************************************************************
 * Class Name                           DatabaseUtilities                    *
 * @author                              Ivan Emmanuel VILLEGAS LIRA          *
 * Date                                 17/06/2016                           *
 * @description                         Cette classe sert à gérér les status 
 *                                      des connexions vers la base de 
 *                                      données et aussi pour modifier
 *                                      le fichier database/properties dans 
 *                                      les resources externes du projet  le    
 * @version                             1.0.0                                *
 *                                                                           *
 * ***************************************************************************
 */

public class DatabaseUtilities {

    String pathParent = null;
    DBConnection connection = new DBConnection();
    Utilities util = new Utilities();

    /**
     * Reçoive des paramètres depuis le fichier @see Connexion.jsp pur obtenir
     * les noms des bases de données disponibles au serveur connecté
     *
     * @param ipServer
     * @param port
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    public String[] getDatabases(String ipServer, int port, String user, String pass) throws SQLException {
        return connection.getDatabases(ipServer, port, user, pass);
    }

    /**
     * Reçoive des paramètres depuis le fichier @see Connexion.jsp vérifie la
     * connexion vers les serveur avec les parametres de connexion
     *
     * @param ipServer
     * @param port
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    public boolean isConnected(String ipServer, int port, String user, String pass) throws SQLException {
        return connection.connectDb(ipServer, port, user, pass);
    }

    /**
     * Fait le configuration du fichier imagys/util/database.properties des
     * résources externes au système
     *
     * @param ipServer
     * @param port
     * @param usr
     * @param pswd
     * @param dbName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean modifyFile(String ipServer, int port, String usr, String pswd, String dbName) throws FileNotFoundException, IOException {
        pathParent = util.getImagysFolder();
        if (!"".equals(ipServer) && !"".equals(port) && !"".equals(usr) && !"".equals(pswd) && !"".equals(dbName)) {
            String path = pathParent + "util/database.properties";
            FileInputStream in;
            Properties props;
            in = new FileInputStream(path);
            props = new Properties();
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(path);
            props.setProperty("ipServer", ipServer);
            props.setProperty("port", String.valueOf(port));
            props.setProperty("dbCatalog", dbName);
            props.setProperty("dbUser", usr);
            props.setProperty("dbPassword", pswd);
            props.store(out, null);
            out.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Design Pattern Singleton qui verifie s'une connexion existe à chaque fois
     * que le utilisateur fait click sur le bouton connect dans le jsp @see
     * Connection s'il existe une la retourne s'il n'existe il retourne null
     * pour gérér des exceptions
     *
     * @param ipServer
     * @param port
     * @param usr
     * @param pswd
     * @param dbName
     * @return
     * @throws SQLException
     */
    public Connection connectPersistence(String ipServer, int port, String usr, String pswd, String dbName) throws SQLException {
        if (DBConnection.connectPersistence(ipServer, port, usr, pswd, dbName) == null) {
            return DBConnection.connectPersistence(ipServer, port, usr, pswd, dbName);
        } else {
            return null;
        }
    }

    /**
     * Ferme la connexion vers la base de données depuis le jsp deconexion @see
     * Deconnexion.jsp au moment de faire logOut du système
     *
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        connection.closeConnection();
    }
}
