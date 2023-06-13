package SQLiteTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Datenbankverbindung {

    private Connection conn;

    public Datenbankverbindung()
    {
        conn = null;
        verbindungAufbauen("test.db");

    }

    public void verbindungAufbauen(String serverURL) {
        try
        {
            //Versuche SQLite-JDBC-Treiber zu laden
            Class.forName("org.sqlite.JDBC");
            //Verbindung zur Datenbank herstellen
            conn = DriverManager.getConnection("jdbc:sqlite:" + serverURL);
            //Erfolgsmeldung ausgeben
            System.out.println("Verbindung mit DB: " + serverURL + " aufgebaut!");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void schuelerAusgeben() {
        try
        {
            //Statementobjekt von der Verbindung holen
            Statement stat = conn.createStatement();
            //Abfrage an Statementobjekt senden -> Ergebnis wird in Resultset (Ergebnistabelle) gespeichert
            ResultSet rs = stat.executeQuery("select * from schueler");
            //Solange Resultset einen naechsten Datensatz hat, hole die einzelnen Werte ueber ihren Bezeichner und gib sie aus
            while(rs.next()) {
            
                System.out.println("ID=" + rs.getInt("id"));
                System.out.println("Name=" + rs.getString("name"));
                System.out.println("Vorname=" + rs.getString("vorname"));
                System.out.println("--------------------------------");
            }
            //Resultset schliessen
            rs.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
    public void verbindungBeenden() {
        
            try
            {
                //Verbindung beenden
                conn.close();
                //Erfolgsmeldung ausgeben
                System.out.println("Verbindung erfolgreich beendet.");
            }
            catch (SQLException e)
            {
                System.out.println(e);;
            }
            
    }

    public void tabelleAufsetzen() {
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists spieler;");
            stat.executeUpdate("create table spieler (id, name, gesamtRunden, gewonnen, verloren);");
            PreparedStatement prep = conn.prepareStatement("insert into schueler values (?, ?, ?, ?);");

            prep.setInt(1, 1);
            prep.setString(2, "Braml");
            prep.setString(3, "Christoph");
            prep.addBatch();

            prep.setInt(1, 2);
            prep.setString(2, "Eckinger");
            prep.setString(3, "Moritz");
            prep.addBatch();

            prep.setInt(1, 3);
            prep.setString(2, "Gredasov");
            prep.setString(3, "Maik");
            prep.addBatch();
            
            prep.setInt(1, 4);
            prep.setString(2, "Kühn");
            prep.setString(3, "Thomas");
            prep.addBatch();
            
            prep.setInt(1, 5);
            prep.setString(2, "Li");
            prep.setString(3, "Kevin");
            prep.addBatch();
            
            prep.setInt(1, 6);
            prep.setString(2, "Moosbauer");
            prep.setString(3, "Andreas");
            prep.addBatch();

            prep.setInt(1, 7);
            prep.setString(2, "Schäfer");
            prep.setString(3, "Adrian");
            prep.addBatch();
            
            prep.setInt(1, 8);
            prep.setString(2, "Loew");
            prep.setString(3, "Moritz");
            prep.addBatch();
            
            prep.setInt(1, 9);
            prep.setString(2, "Tonkich");
            prep.setString(3, "Daniil");
            prep.addBatch();
            
            prep.setInt(1, 10);
            prep.setString(2, "Weber");
            prep.setString(3, "David");
            prep.addBatch();
            
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
           
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        public void inTabelleEinfuegen()
    }

    
}