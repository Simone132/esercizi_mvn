import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InserisciManual {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Nome del database non fornito. Uso 'database_collegato' come nome di default.");
            args = new String[] { "database_collegato" };
        }

        Connection conn = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // Carico il driver JDBC di SQLite
            Class.forName("org.sqlite.JDBC");

            // Creo una connessione al database
            String url = "jdbc:sqlite:" + args[0] + ".db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connessione a SQLite stabilita.");
            VisualizzaDati.main(args);

            // query x i dati utenti che poi inserira manualmente
            String sqlInserisciDatiUtente = "INSERT INTO prodotti(nome, quantita, prezzo, id_categoria) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmtInserisciDatiUtente = conn.prepareStatement(sqlInserisciDatiUtente);

            // inserisce il nome del prodtoo
            System.out.println("inserisci nome prodotto");
            String nomeProdotto = scanner.nextLine();
            pstmtInserisciDatiUtente.setString(1, nomeProdotto);
            boolean datiInseritiCorrettamente = false;
            while (datiInseritiCorrettamente == false) {
                try {
                    // inserisci quantita
                    System.out.println("inserisci quantità prodotto");
                    int quantitaProdotto = Integer.parseInt(scanner.nextLine());
                    pstmtInserisciDatiUtente.setInt(2, quantitaProdotto);

                   
                    datiInseritiCorrettamente = true;
                } catch (Exception e) {
                    System.out.println("i dati inseriti della quantità non sono corretti. Riprova");
                }
            }
            datiInseritiCorrettamente = false;
            while (datiInseritiCorrettamente == false){
                try {
                     // inserisci prezzo
                    System.out.println("inserisci prezzo prodotto");

                    // Leggi l'input dell'utente come una stringa
                    String input = scanner.nextLine();

                    // Sostituisci le virgole con punti nella stringa
                    input = input.replace(",", ".");

                    // Converte la stringa in un valore double
                    double numero = Double.parseDouble(input);
                    pstmtInserisciDatiUtente.setDouble(3, numero);
                    datiInseritiCorrettamente = true;
                } catch (Exception e) {
                    System.out.println("i dati inseriti del prezzo non sono corretti. Riprova");

                }
            }

            datiInseritiCorrettamente = false;

            // l'utente inserisce il valore di una categoria, o sceglie se creane una nuova
            while (datiInseritiCorrettamente == false) {
                try {
                    // preparazione ed esecuzione della query per ottenere tutte le righe e colonne
                    // della tabella
                    // categorie usando sqlSelectALLCategories
                    String sqlSelectALLCategories = "SELECT * FROM categorie";
                    PreparedStatement ptsmtSelectALLCategories = conn.prepareStatement(sqlSelectALLCategories);
                    ResultSet resultSetALLCategories = ptsmtSelectALLCategories.executeQuery();
                    // eseguiamo la query e per ogni riga ottenuta, stampa l'id e il nome della
                    // categoria, prima stampa anche il numero 0 che ha la possbiliya di creare una
                    // nuova categroia

                    System.out.println("seleziona La Categoria dell'oggetto ");
                    System.out.println(0 + " crea nuova categroia");
                    while (resultSetALLCategories.next() == true) {
                        System.out
                                .println(resultSetALLCategories.getInt("id") + " "
                                        + resultSetALLCategories.getString("nome"));
                    }
                    int categoriaScelta = Integer.parseInt(scanner.nextLine());
                    // esegue una seconda query che seleziona l'id della categoria che ha scritto
                    // l'utente
                    String sqlControlloCategoria = "SELECT categorie.id AS id FROM categorie WHERE categorie.id = ?";
                    PreparedStatement ptsmtControlloCategoria = conn.prepareStatement(sqlControlloCategoria);
                    ptsmtControlloCategoria.setInt(1, categoriaScelta);
                    ResultSet resultSetSelectedCategories = ptsmtControlloCategoria.executeQuery();

                    // se dal risultato della seconda query esce almeno una riga, allora aggiunge
                    // come quarto valore della prima query
                    // il valore dell'id che è risultato dalla prima query
                    if (resultSetSelectedCategories.next() == true && categoriaScelta != 0) {
                        int id_categoria = resultSetSelectedCategories.getInt("id");
                        pstmtInserisciDatiUtente.setInt(4, id_categoria);
                        pstmtInserisciDatiUtente.executeUpdate();
                        System.out.println("dati inseriti con successo");
                        datiInseritiCorrettamente = true;
                        VisualizzaDati.main(args);
                    } else if (categoriaScelta == 0) {
                        // altrimenti se l'utente scrive 0, gli viene chiesto il nome della nuova
                        // categoria ed essa con una nuova query viene aggiunta alla tabella categoria
                        System.out.println("inserisci nome nuova categoria");
                        String nuovaCategoria = scanner.nextLine();
                        String sqlInserisciCategoria = "INSERT INTO categorie(nome) VALUES(?)";
                        PreparedStatement pstmtInserisciCategoria = conn.prepareStatement(sqlInserisciCategoria);
                        pstmtInserisciCategoria.setString(1, nuovaCategoria);
                        pstmtInserisciCategoria.executeUpdate();

                        // dopo avere creato la categoria, seleziona l'id della nuova categoria con
                        // sqlCercaLaNuovaCategoria
                        String sqlCercaLaNuovaCategoria = "SELECT categorie.id AS id FROM categorie WHERE categorie.nome = ?";
                        PreparedStatement ptsmtCercaLaNuovaCategoria = conn.prepareStatement(sqlCercaLaNuovaCategoria);
                        ptsmtCercaLaNuovaCategoria.setString(1, nuovaCategoria);

                        // esegue la query e salva il risultato in un result set nuovo chiamato
                        // resultSetCercaLaNuovaCategoria
                        ResultSet resultSetCercaLaNuovaCategoria = ptsmtCercaLaNuovaCategoria.executeQuery();

                        // prende il valore della colonna id dal result set e esegue la query di
                        // inserimento generale
                        int id_categoria = resultSetCercaLaNuovaCategoria.getInt("id");
                        pstmtInserisciDatiUtente.setInt(4, id_categoria);
                        pstmtInserisciDatiUtente.executeUpdate();
                        System.out.println("dati inseriti con successo");
                        datiInseritiCorrettamente = true;
                        VisualizzaDati.main(args);
                    } else {
                        System.out.println("la categoria selezionata non esiste, riprova");
                    }
                } catch (Exception e) {
                    System.out.println("il numero che hai inserito, è stato inserito in un formato sbagliato, riprova");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    // scanner.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}