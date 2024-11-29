Entity manager
- Quell'attore che si occupa di gestire le entità o diversamente chiamate modelli.
- Consente di gestire operazioni di persistenza dei dati (persistenza = memorizzazione definitiva dei dati)

@Column
- Aggiunge informazioni agli attributi della classe

Derived query
- E' un sistema tramite il quale Hibernate grazie ad una convenzione da seguire sul nome dei metodi costruisce in automatico le query sql corrispondenti (come visto ad esempio in Eloquent)

getAuthorByName(String name)

select * from authors where name = "name";

findByName(String pupo);

select * from authors where name = "pupo";

AssertJ
- E' una libreria che tramite delle asserzioni mi fornisce uno strumento di test potentissimo
- Mi aspetto che se chiamo l'utente con id 1 questo avrà nome pari a Giuseppe.
- Definisci vero che se recupero un dato dal database con id 1 il valore della colonna corrisponde al nome è pari a GIuseppe.


Controller
- Api -> responsabili della gestione delle richieste http provenienti da altre applicazioni
    - Json -> è uno dei formati più diffusi per lo scambio di dati
    - Protocollo REST (Rappresentational State Transfer) 
        RestFull service -> Senza stato, le risposte vengono date con tutte le informazioni necessarie sena la necessità di memorizzarle all'interno del server
- Web -> responsabili della gestione delle richieste http provenienti dall'applicazione stessa creando una dinamicità con i client

@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping


Modifica di hibernate
- Hibernate utilizza l'id per capire quale operazione compiere. Se l'id esiste allora farà una modifica(In realtà sostituzione) se l'id invece non esiste creerà un nuovo record
- Quindi il body delle richieste di tipo put devono avere tutti id ati compresi anche quelli pre esistenti