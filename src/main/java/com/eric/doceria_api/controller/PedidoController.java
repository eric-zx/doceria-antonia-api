package com.eric.doceria_api.controller;

import com.eric.doceria_api.model.Pedido;
import com.eric.doceria_api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public List<Pedido> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return repository.save(pedido);
    }
}