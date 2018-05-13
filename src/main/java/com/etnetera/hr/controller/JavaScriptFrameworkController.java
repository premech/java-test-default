package com.etnetera.hr.controller;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Simple REST controller for accessing application logic.
 *
 * @author Etnetera
 */
@RestController
public class JavaScriptFrameworkController {

    private final JavaScriptFrameworkRepository repository;

    @Autowired
    public JavaScriptFrameworkController(JavaScriptFrameworkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/findAll")
    public Iterable<JavaScriptFramework> findAll() {
        return repository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<JavaScriptFramework> create(@Valid @RequestBody JavaScriptFramework jsf) {
        repository.save(jsf);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/findAll").build()
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
