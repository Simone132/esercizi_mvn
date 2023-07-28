import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserisciDatiCollegati {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[]{"database_collegato"};
        }

        Connection conn = null;
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);

            System.out.println("Connessione a SQLite stabilita.");

            // Aggiungi dati di esempio
            String sqlInserisci2 = "INSERT INTO categorie(nome) VALUES(?)";
            PreparedStatement pstmt2 = conn.prepareStatement(sqlInserisci2);
            pstmt2.setString(1, "Frutta");
            pstmt2.executeUpdate();

            // Aggiungi dati di esempio
            String sqlInserisci = "INSERT INTO prodotti(nome, quantita, prezzo, id_categoria) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlInserisci);
            pstmt.setString(1, "Prodotto1");
            pstmt.setInt(2, 10);
            pstmt.setDouble(3, 9.99);
            pstmt.setInt(4, 1);
            pstmt.executeUpdate();

            System.out.println("Dati inseriti con successo.");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}