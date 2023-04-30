package mk.ukim.finki.elibrary.elibrary.service;

import mk.ukim.finki.elibrary.elibrary.model.Country;
import java.util.List;
import java.util.Optional;


public interface CountryService {

    List<Country> listAll();

    Optional<Country> findById(Long id);

    Optional<Country> save(String name, String continent);

    Optional<Country> edit(Long id,String name, String continent);

    void deleteById(Long id);

}
