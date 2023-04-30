package mk.ukim.finki.elibrary.elibrary.repository;

import mk.ukim.finki.elibrary.elibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
