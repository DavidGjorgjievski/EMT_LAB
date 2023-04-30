package mk.ukim.finki.elibrary.elibrary.web.rest;

import mk.ukim.finki.elibrary.elibrary.model.enumerations.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/books/categories")
public class CategoryRestController {

    @GetMapping
    private  List<String> findALl(){
        return Arrays.stream(Category.values())
                .map(category -> category.name())
                .collect(Collectors.toList());
    }
}