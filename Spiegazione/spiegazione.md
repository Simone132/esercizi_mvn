 # creazione di un database
- come prima cosa abbiamo creato un databse con  questo comando :
     mvn archetype:generate -DgroupId=com.example -DartifactId=simple-webapp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

- dopo aver creato un database abbiamo aggiunto al file pom.xml queste dependency che sonole ultime più aggiornate :
        < dependency >
        < groupId >org.xerial< /groupId >
        < artifactId >sqlite-jdbc< /artifactId >
        < version >3.42.0.0< /version >
    < /dependency >
    dopo aver aggiunto le dependency abbiamo creato nel main la cartella java
    con  i seguenti file CancellaDati, CreaDatabase,inserisciDatimanual,inserisciDummyDatas,visualizzaDati,modificadati,main,deletedatabase, e salvainCSV.
    una volta creati i file ci siamo divisi in gruppi da tre  persone e ci sono state affidate delle task.
    per avviare il programma bisogna  uilizzare questo comando:

    mvn compile


    poi

    mvn exec:java -D"exec.mainClass"="Main"

    o in alterntiva anche questo:

    mvn exec:java -Dexec.mainClass="Main"




    **io  il primo giorno** ero nel gruppo numero 2 e avevo il compito di creare delle foreign key  con la funzionalità di unire due tabelle in questo caso la tabella prodotti con la tabella categorie  , e creare la join select  che serve per usare i dati di un altra tabella dentro ad un altra che sono collegate da una foreign key.
    e lo abbiamo fatto con questo comando  :

        "FOREIGN KEY(id_categoria) REFERENCES categorie(id)";";




    **il secondo giorno**  mi sono spostato in un altro gruppo e la seconda task  era finire la tabella  modificadati e cancella dati
    il secondo giorno mi sono occupato di fare il file cancella dati e volevamo fare un bel lavoro quindi ci abbiamo impiegato un pò più di tempo rispetto al previsto e per creare  questo funzione all' interno del file abbiamo  abbiamo creato una domanda all' utente  di inserire l' ID del prodotto che voleva cancellare una volta inserito l' id allora partiva il try  che attraverso queto comando :

                String sql = "DELETE FROM prodotti WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(idProdotto));
            pstmt.executeUpdate();

    permette di cancellare l' id che scrive l utente e non un id selezionato a caso  oppure un id selezionato da noi e alla fine di tutto questo se  tutto è andato correttamente lui ti stampa dati cancellati con successo.

    poi pero il secondo giorno non siamo riusciti a portare a tremine la seconda task che era quella di finire anche il modifica dati manual.





    **il terzo giorno** invece dovevamo finire l' ultima parte di modifica dati manual  e per farlo abbiamo  creato un ciclo if con le varie condizioni e funzionava ti permette di modificare su richiesta dell' utente le colonne nome,prezzo,quantità ma non ti permette di modificare le colonne più importatnti come l' id e la categoria prodotti
    poi nel pomeriggio abbiamo provato a creare una funzione che se tu scrivevi male una categoria ti chiedesse se ne vuoi creare una nuova o aggiungerla ad una esistente ma questo ancora non lo abbiamo finito.



    per inserire  inseire i nostri file nel main abbiamo utilizzato questo comando che li richiama :
    
    try {
                    switch (choice) {
                        case 1:
                            InserisciDummyDatas.main(new String[] { databaseName });
                            break;
                        case 2:
                            SalvaInCSV.main(new String[] { databaseName });
                            break;
                        case 3:
                            ModificaDati.main(new String[] { databaseName });
                            break;
                        case 4:
                            CancellaDati.main(new String[] { databaseName });
                            break;
                        case 5:
                            InserisciManual.main(new String[] { databaseName });
                            break;
                        case 6:
                            System.out.println("Torna al menu principale.");
                            cont = false;
                            break;
                        default:
                            System.out.println("Opzione non valida. Riprova.");
                    }

                    // Stampare i dati del database dopo ogni azione, eccetto l'uscita
                    if (cont) {
                        VisualizzaDati.main(new String[] { databaseName });
                    }

                }