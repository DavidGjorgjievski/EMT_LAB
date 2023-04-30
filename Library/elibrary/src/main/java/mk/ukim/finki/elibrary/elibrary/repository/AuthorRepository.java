package mk.ukim.finki.elibrary.elibrary.repository;

import mk.ukim.finki.elibrary.elibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

}
