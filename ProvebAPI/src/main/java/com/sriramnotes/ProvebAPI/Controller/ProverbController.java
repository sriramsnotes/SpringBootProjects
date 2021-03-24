package com.sriramnotes.ProvebAPI.Controller;

import java.util.List;

import com.sriramnotes.ProvebAPI.Data.Proverb;
import com.sriramnotes.ProvebAPI.Data.ProverbRepository;
import com.sriramnotes.ProvebAPI.Exceptions.ProverbNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProverbController {
    private final ProverbRepository repository;

    ProverbController(ProverbRepository repository) {
        this.repository = repository;
    }

    // get all proverbs
    @GetMapping("/proverbs")
    List<Proverb> all() {
        return repository.findAll();
    }

    //add a new proverb
    @PostMapping("/proverbs")
    Proverb newProverb(@RequestBody Proverb newProverb) {
        return repository.save(newProverb);
    }

    //get a specific proverb
    @GetMapping("/proverbs/{id}")
    Proverb one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProverbNotFoundException(id));
    }

    //replace a proverb
    @PutMapping("/proverbs/{id}")
    Proverb replaceProverb(@RequestBody Proverb newProverb, @PathVariable Long id) {

        return repository.findById(id)
                .map(proverb -> {
                    proverb.setProverbString(newProverb.getProverbString());
                    proverb.setAuthor(newProverb.getAuthor());
                    return repository.save(proverb);
                })
                .orElseGet(() -> {
                    newProverb.setId(id);
                    return repository.save(newProverb);
                });
    }

    //delete a proverb
    @DeleteMapping("/proverbs/{id}")
    void deleteProverb(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
