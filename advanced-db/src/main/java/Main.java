import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crea uno Scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);
        String continua;

        do {
            // Stampa il menu
            System.out.println("Seleziona un'opzione:");
            System.out.println("1: Crea il database e le tabelle");
            System.out.println("2: Inserisci i dati nelle tabelle");
            System.out.println("3: Visualizza i dati");
            System.out.println("4: Modifica i dati");
            System.out.println("5: Cancella i dati");
            System.out.println("6: Salva i dati in un file CSV");

            // Leggi la scelta dell'utente
            int scelta = scanner.nextInt();
            scanner.nextLine(); // Rimuove il newline rimanente

            // Esegui l'operazione scelta
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci il nome del database da creare:");
                    break;
                case 2:
                    System.out.println("Inserisci il nome del database nel quale inserire i dati:");
                    break;
                case 3:
                    System.out.println("Inserisci il nome del database dal quale visualizzare i dati:");
                    break;
                case 4:
                    System.out.println("Inserisci il nome del database del quale modificare i dati:");
                    break;
                case 5:
                    System.out.println("Inserisci il nome del database dal quale cancellare i dati:");
                    break;
                case 6:
                    System.out.println("Inserisci il nome del database dal quale estrarre i dati:");
                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci 1, 2, 3, 4, 5, 6.");
            }
            String dbName = scanner.nextLine();

            switch (scelta) {
                case 1:
                    Crealo.main(new String[] { dbName });
                    break;
                case 2:
                    InserisciDatiCollegati.main(new String[] { dbName });
                    break;
                case 3:
                    VisualizzaDati.main(new String[] { dbName });
                    break;
                case 4:
                    ModificaDati.main(new String[] { dbName });
                    break;
                case 5:
                    CancellaDati.main(new String[] { dbName });
                    break;
                case 6:
                    SalvaInCSV.main(new String[] { dbName });
                    break;
                default:
                    System.out.println("Scelta non valida. Inserisci 1, 2, 3, 4, 5, 6.");
            }

            // Chiedi all'utente se desidera continuare
            System.out.println("Vuoi eseguire un'altra operazione? (S/N)");
            continua = scanner.nextLine();

        } while (continua.equalsIgnoreCase("S"));

        scanner.close();
    }
}