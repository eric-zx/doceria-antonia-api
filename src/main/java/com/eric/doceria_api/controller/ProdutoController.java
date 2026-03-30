package com.eric.doceria_api.controller;

import com.eric.doceria_api.model.Produto;
import com.eric.doceria_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200") // <--- ADICIONE ESTA LINHA AQUI
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200") // Reforço para o método de listagem
    public List<Produto> listar() {
        return repository.findAll();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200") // Reforço para o cadastro
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200") // Reforço para a exclusão
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}