package it.aulab.progetto_blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import it.aulab.progetto_blog.models.Author;

public interface AuthorRepository extends ListCrudRepository<Author, Long> {
    //Derived query
    //se l'attributo nel modello si chiama name dopo il by dobbiamo inserire necessariamente Name
    List<Author> findByName(String firstname);
    List<Author> findBySurname(String lastname);
    List<Author> findByNameAndSurname(String firstname, String lastname);

    //Query nativa
    //"SELECT * FROM authors WHERE authors.firstname = 'Giuseppe'" (Aliasing)
    @Query(value = "SELECT * FROM authors a WHERE a.firstname = 'Giuseppe'", nativeQuery = true)
    List<Author> authorsWithSameName();

    //Query non native
    @Query(value = "SELECT a FROM Author a WHERE a.name= 'Giuseppe'")
    List<Author> authorsWithSameNameNonNative();
}