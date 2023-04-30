package mk.ukim.finki.elibrary.elibrary.model.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.elibrary.elibrary.model.dto.BookDto;
import mk.ukim.finki.elibrary.elibrary.model.enumerations.Category;
import mk.ukim.finki.elibrary.elibrary.service.AuthorService;
import mk.ukim.finki.elibrary.elibrary.service.BookService;
import mk.ukim.finki.elibrary.elibrary.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {
        this.countryService.save("Macedonia", "Europe");
        this.countryService.save("Australia", "Oceania");
        this.countryService.save("USA", "North America");
        this.countryService.save("China", "Asia");
        this.countryService.save("Brazil", "South America");

        this.authorService.save("Scott", "Fitzgerald", Long.parseLong("3"));
        this.authorService.save("Clarice", "Lispector", Long.parseLong("5"));
        this.authorService.save("Thomas", "King", Long.parseLong("5"));
        this.authorService.save("Blaze", "Koneski", Long.parseLong("1"));
        this.authorService.save("Koco", "Racin", Long.parseLong("1"));
        this.authorService.save("Ernest", "Hemingway", Long.parseLong("3"));

        this.bookService.save( new BookDto( "The Golden Gate", Category.NOVEL,Long.parseLong("2"), 89 ) );
        this.bookService.save( new BookDto( "The Hound",  Category.FANTASY,Long.parseLong("3"), 14 ) );
        this.bookService.save( new BookDto( "Lade", Category.NOVEL,Long.parseLong("4"), 45 ) );
        this.bookService.save( new BookDto( "Pirej",  Category.NOVEL,Long.parseLong("5"), 70 ) );
        this.bookService.save( new BookDto( "Skrzavec", Category.CLASSICS,Long.parseLong("1"), 22 ) );
    }


}