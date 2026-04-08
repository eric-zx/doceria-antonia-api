package com.eric.doceria_api.controller;

import com.eric.doceria_api.model.Produto;
import com.eric.doceria_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                // Retorna 200 OK ou 204 No Content
                return ResponseEntity.ok().body("Produto removido com sucesso!");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        } catch (Exception e) {
            // ESSA LINHA É A CHAVE: Ela vai mostrar no seu IntelliJ o erro real
            System.err.println("ERRO AO EXCLUIR: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro de integridade: Este item antigo pode estar vinculado a um pedido ou histórico e não pode ser removido.");
        }
    }
}