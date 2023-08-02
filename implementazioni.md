# implementazioni su gestionale database

## GRUPPO 1

**MODIFICHE SPECIFICHE SU MAIN**

1 - Fix di logica di selezione degli elementi del menu in quanto ad esempio nella pagina visualizzaDati, dopo la scelta dell'utente viene mantenuto un NewLine che gfa andare il Min al comando successivo mandando in errore il programma

2 - Togliere Visualizza Dati dal menu

3- avere una visualizzazione dei dati completi del database successivamente ad ogni scelta, questo per permettere di avere un'anteprima dei dati in modificaDati, CancellaDati, inserisci dati ed in salvaInCSV tipo cos�
```java
// Stampare i dati del database dopo ogni azione, eccetto l'uscita
                if (cond) {
                    VisualizzaDati.main(new String[] { databaseName });
                }
```
## GRUPPO 2

**MODIFICHE SPECIFICHE SU DATABASE**

1 - Aggiungere la foreign key che permette di creare una relazione tra le tabelle e permetter� anche di creare delle JOIN select

**MODIFICHE SPECIFICHE SU CLASSI**

1 - Implementare le JOIN select su i files:

- CancellaDati
- InserisciDatiCollegati
- ModificaDati
- SalvaInCSV
- VisualizzaDati

## GRUPPO 3

2 - in CancellaDati creare una maschera di cancellazione dati che sia comoda e permetta di cancellare i recoed per *ID*

3 - in InserisciDatiCollegati creare una maschera di inserimento dati che sia comoda chiedendo all'utente i dati da inserire uno per uno tipo cos�

- Inserire nome prodotto
- Inserire quantit�
- Inserire prezzo
- Inserire nome categoria (grazie al fatto che abbiamo una JOIN select) o almeno inserire l ID della categoria

4 - in modifica dati creare una maschera di modifica dati

- Inserire l'ID del prodotto da modificare
- Quale campo cvuoi modificare tra: nome quantita prezzo o categoria?

5 - salva in CSV

- Quale tipo di visualizzazione vuoi tra tabella e resoconto?

1 - in caso di tabella stampa l'intestazione (header) ed i dati incolonnati utilizzando \t

2 in caso di visualizzazione resoconto tipo questa:

ID: 1, Nome: Prodotto1, Quantita: 10, Prezzo: 9.99, ID_Categoria: 1

# GRUPPI:

1 () - MODIFICHE SPECIFICHE SU MAIN

2 () - MODIFICHE SU DATABASE ED IMPLEMENTA LE JOIN SELECT SU TUTTE LE CLASSI

3 () - RICEVE DAL 2 GRUPPO LE MODIFICHE AI FILES MA NEL FRATTEMPO IMPLEMENTA LA LOGICA DI SELEZIONE, CANCELLAZIONE ED MODIFICA DELLE CLASSI