package mk.ukim.finki.elibrary.elibrary.service.Impl;

import mk.ukim.finki.elibrary.elibrary.model.Country;
import mk.ukim.finki.elibrary.elibrary.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.elibrary.elibrary.repository.CountryRepository;
import mk.ukim.finki.elibrary.elibrary.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name,continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id).orElseThrow(()->new CountryNotFoundException(id));
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(this.countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}
