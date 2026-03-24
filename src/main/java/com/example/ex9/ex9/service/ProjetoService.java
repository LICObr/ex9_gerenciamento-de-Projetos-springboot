package com.example.ex9.ex9.service;

import com.example.ex9.ex9.entity.Projeto;
import com.example.ex9.ex9.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    //injetar
    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    //listar
    public List<Projeto> findAll(){
        return projetoRepository.findAll();
    }

    //criar
    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);
    }

    //deletar
    public void delete(Long id){
        projetoRepository.deleteById(id);
    }

    //buscar por id
    public Optional<Projeto> buscar(Long id){
        return projetoRepository.findById(id);
    }

    //atualizar
    public Projeto update(Long id, Projeto projeto){
        projeto.setId(id);
        return projetoRepository.save(projeto);
    }

}
