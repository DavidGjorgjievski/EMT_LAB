package mk.ukim.finki.elibrary.elibrary.web.rest;

import mk.ukim.finki.elibrary.elibrary.model.Author;
import mk.ukim.finki.elibrary.elibrary.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> listAll(){
        return this.authorService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id){
        return this.authorService.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> save(@RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam Long countryId) {
        return this.authorService.save(name, surname, countryId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Author> edit(@PathVariable Long id,
                                       @RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam Long countryId){
        return this.authorService.edit(id,name,surname,countryId)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.authorService.deleteById(id);
        if( this.authorService.findById(id).isEmpty() )
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
