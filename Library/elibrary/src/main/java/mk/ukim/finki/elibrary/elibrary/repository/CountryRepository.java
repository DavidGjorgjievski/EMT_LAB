package mk.ukim.finki.elibrary.elibrary.repository;

import mk.ukim.finki.elibrary.elibrary.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

}
