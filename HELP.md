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

Service
- Si occupano della logica di business del nostro applicativo

Architettura
View - Controllers - Services - Repositories - DB

Quando avviene un injection che non segue il patterno viene definito antipatterns


TEMPALTE ENGINE
- Avete già avuto a che fare con Blade (Laravel)
- Thymeleaf è il nostro nuovo motore di template che utilizzeremo

Server side rendering (folder templates)
- Quando è il server ce tramite template crea la paginetta html con tutto quello che gli serve e poi la manda al client

Client side rendering (folder static)
- La paginetta html ha tutto quello che gli serve (parte javascript, css, cdn, ha anche un folder da cui prendere le immagini)



th:text -> manipolazione di testo
th:each -> attiva il foreach di thymeleaf
th:action -> richiama l'uri che sarà collegato all'handler nel controller
th:object -> crea l'aggancio di un oggetto al template
th:field -> aggancia il template ad un attributo di un oggetto
th:href -> collega l'anchor ad un uri indirizzo dinamico

@{/authors} -> questa sintassi indica un uri dinamico

DAO -> Model

DTO -> Data transfer object potrebbe ANCHE differire come informazioni rispetto ai DAO delle nostre logiche
I dto nascono per
- Nascondere l'implementazioni all'esterno
- Creano una interfaccia molto semplice rispetto alla mole di dati che vengono realmente utilizzati, cosi possiamo conseganre al FE un descrizione complessiva dei dati senza che debbano necessariamente conoscere il loro effettivo utilizzo in memoria


SpEL -> Spring expression language (Dialect)
${author.id}
@{/authors/${ciccia}}
*{name}