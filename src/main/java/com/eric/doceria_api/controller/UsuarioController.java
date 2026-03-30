package com.eric.doceria_api.controller;

import com.eric.doceria_api.model.Usuario;
import com.eric.doceria_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200") // Permite o Angular acessar este controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Usuario> listar() {
        return repository.findAll();
    }
}