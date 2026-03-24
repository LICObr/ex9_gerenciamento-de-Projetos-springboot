package com.example.ex9.ex9.controller;

import com.example.ex9.ex9.entity.Projeto;
import com.example.ex9.ex9.repository.ProjetoRepository;
import com.example.ex9.ex9.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    //injecao de dependencia
    @Autowired
    private final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> findAll(){
        List<Projeto> resquest = projetoService.findAll();
        return ResponseEntity.ok().body(resquest);
    }

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto projeto){
        Projeto save = projetoService.save(projeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(projeto.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        projetoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id){
        return projetoService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @RequestBody Projeto projeto){
        return ResponseEntity.ok(projetoService.update(id, projeto));
    }

}
