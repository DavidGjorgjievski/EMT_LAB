package mk.ukim.finki.elibrary.elibrary.web.rest;

import mk.ukim.finki.elibrary.elibrary.model.Country;
import mk.ukim.finki.elibrary.elibrary.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id){
        return this.countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestParam String name, @RequestParam String continent){
        return this.countryService.save(name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Country> edit(@PathVariable Long id,@RequestParam String name,@RequestParam String continent){
        return this.countryService.edit(id,name,continent)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.countryService.deleteById(id);
        if(this.countryService.findById(id).isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
