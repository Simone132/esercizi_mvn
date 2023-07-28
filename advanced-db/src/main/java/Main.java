import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean cont = true;
        String databaseName = null;

        while (cont) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1: Crea DB");
            System.out.println("2: Inserisci dati");
            System.out.println("3: Salva in CSV");
            System.out.println("4: Modifica dati");
            System.out.println("5: Cancella dati");
            System.out.println("6: Esci");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline lasciato da nextInt()

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Inserisci il nome del database:");
                        databaseName = scanner.nextLine();
                        Crealo.main(new String[] { databaseName });
                        break;
                    case 2:
                        InserisciDatiCollegati.main(new String[] { databaseName });
                        break;
                    case 3:
                        SalvaInCSV.main(new String[] { databaseName });
                        break;
                    case 4:
                        ModificaDati.main(new String[] { databaseName });
                        break;
                    case 5:
                        CancellaDati.main(new String[] { databaseName });
                        break;
                    case 6:
                        System.out.println("Addio!");
                        cont = false;
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                }

                // Stampare i dati del database dopo ogni azione, eccetto l'uscita
                if (cont) {
                    VisualizzaDati.main(new String[] { databaseName });
                }

            } catch (Exception e) {
                System.out.println("Si � verificato un errore: " + e.getMessage());
            }
        }

        scanner.close();
    }
}