package mk.ukim.finki.elibrary.elibrary.service;

import mk.ukim.finki.elibrary.elibrary.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(String name,String surname,Long countryId);

    Optional<Author> edit(Long id,String name,String surname,Long countryId);

    void deleteById(Long id);

}
