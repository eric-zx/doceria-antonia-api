package com.eric.doceria_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itens_pedido")
@Data
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Double precoUnitario;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}